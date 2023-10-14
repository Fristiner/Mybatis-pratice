package com.ma.utils;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author ma
 * @version 1.0.0
 * @data 2023/10/12
 * @className java.lang.String
 * 生成dao的代理类  可以动态生成dao的代理类
 */

public class GenerateDaoProxy {
    /**
     * 生成 dao接口的实现类，并将实现的类的对象创建出来并返回
     *
     * @param daoInterface 道接
     * @return 对象
     */
    public static Object generate(SqlSession sqlSession, Class daoInterface) {
        // 类池
        ClassPool pool = ClassPool.getDefault();
        // 制造类
        CtClass ctClass = pool.makeClass(daoInterface.getName() + "Proxy");
        // 在内存中
        // 制造接口
        CtClass CtInterface = pool.makeInterface(daoInterface.getName());
        ctClass.addInterface(CtInterface);


        // 实现接口中所有的方法
        Method[] methods = daoInterface.getDeclaredMethods();

        Arrays.stream(methods).forEach(method -> {
            // method 接口中是抽象方法
            // 将method 抽象方法进行实现

            try {
                // Account selectByActno(String actno);
                // public Account selectByActno
                //  int updateByActno(Account act);
                StringBuilder methodCode = new StringBuilder();
                methodCode.append("public ");
                methodCode.append(method.getReturnType().getName());
                methodCode.append(" ");
                methodCode.append(method.getName());
                methodCode.append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    methodCode.append("arg" + i);
                    if (i != parameterTypes.length - 1) {
                        methodCode.append(",");
                    }
                }
                // 需要方法的形式参数列表
                methodCode.append(")");
                methodCode.append("{");
                // 需要方法体中的代码
                methodCode.append("org.apache.ibatis.session.SqlSession sqlSession = com.ma.utils.SqlSessionUtil.openSession();");
//                methodCode.append("sqlSession.")
                // 这里是动态的上面的是静态的

                // sql 语句的id  就可以获取那个sql 语句
                // 返回sql command
                // 追加的方法
                // sql 语句的id 是框架使用者提供的
                // 规定： 凡是使用GenerateProxy方法的
                // sqlId  namespace必须是dao接口的全限定名称。
                // id 必须是dao接口的方法名

                String sqlId = daoInterface.getName() + "." + method.getName();
                SqlCommandType sqlCommandType = sqlSession.getConfiguration().getMappedStatement(sqlId).getSqlCommandType();
//                if (sqlCommandType == SqlCommandType.INSERT) {
//                    methodCode.append("sqlSession.insert(");
//                }
//                if (sqlCommandType == SqlCommandType.DELETE) {
//
//                }

                if (sqlCommandType == SqlCommandType.UPDATE) {
                    methodCode.append("return sqlSession.update(\"").append(sqlId).append("\", arg0);");
                    // return sqlSession.update("updateByActno", act);
                }
                if (sqlCommandType == SqlCommandType.SELECT) {
                    //return (Account) sqlSession.selectOne("selectByActno", actno);
                    String name = method.getReturnType().getName();

                    methodCode.append("return (").append(name).append(")sqlSession.selectOne(\"").append(sqlId).append("\", arg0);");
                }
                // 我就是我自己的谁在我说的地方


                methodCode.append("}");

                // 方法代码片段
                CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);

                ctClass.addMethod(ctMethod);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // 创建对象


        Object obj = null;
        try {
            Class<?> clazz = ctClass.toClass();
            obj = clazz.newInstance();
        } catch (CannotCompileException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return obj;

    }
}

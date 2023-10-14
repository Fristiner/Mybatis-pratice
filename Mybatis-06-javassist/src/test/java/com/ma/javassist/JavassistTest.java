package com.ma.javassist;

import com.ma.bank.dao.AccountDao;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ma
 * @version 1.0.0
 * @data 2023/10/12
 * @className java.lang.String
 */

// Javassist

public class JavassistTest {

    @Test
    public void testGenerateImpl() throws CannotCompileException, InstantiationException, IllegalAccessException {
        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass = pool.makeClass("com.ma.bank.dao.impl.AccountDaoImpl");

        // 制造接口

        CtClass ctInterface = pool.makeInterface("com.ma.bank.dao.AccountDao");
        // 添加接口中的类
        ctClass.addInterface(ctInterface);
        // 实现接口中的方法
        // 制造方法

        CtMethod ctMethod = CtMethod.make("public void delete(){System.out.println(\"hello world! \");}", ctClass);
        //
        ctClass.addMethod(ctMethod);
        // 在内存中生成类
        //
        Class<?> clazz = ctClass.toClass();
        AccountDao accountDao = (AccountDao)clazz.newInstance();

        accountDao.delete();




    }






    @Test
    public void testGenerateFirstClass() throws CannotCompileException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 获取类池，类池生成class类
        ClassPool pool = ClassPool.getDefault();
        // 制造类 需要告诉类名是什么
        CtClass ctClass = pool.makeClass("com.ma.bank.dao.impl.AccountDaoImpl");

        // 制造方法
        // 第一个传递方法名称  第二个类的类型
        String methodCode = "public void insert(){System.out.println(123);}";
        CtMethod ctMethod = CtMethod.make(methodCode, ctClass);
        // 将方法添加到类中
        ctClass.addMethod(ctMethod);
        // 在内存中生成class

        ctClass.toClass();



        // 类加载到JVM中
        // 反射
        Class<?> clazz = Class.forName("com.ma.bank.dao.impl.AccountDaoImpl");

        Object object = clazz.newInstance();
        // 创建对象
        Method insertMethod = clazz.getDeclaredMethod("insert");
        // 调用方法
        insertMethod.invoke(object);



    }
}

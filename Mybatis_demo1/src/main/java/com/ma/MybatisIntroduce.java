package com.ma;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* *
 * @packing com.ma
 * @author mtc
 * @date 14:46 10 08 14:46
 *
 */
public class MybatisIntroduce {
    public static void main(String[] args) throws IOException {
        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 输入流指向配置文件
//        FileInputStream fileInputStream = new FileInputStream("mybatis-config.xml");
        // 默认从类的根路径查找资源
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);

        // 获取SqlSession对象
        // 在这里添加事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
//     没有开启事务  没有执行conn.setAutoCommit(false) 没有开启事务
        //  执行任何一行dml 语句都会执行
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 指向sql语句
        // 传入sql语句的id
        int count = sqlSession.insert("insertCar");
        // 返回值式影响数据库表当的记录条数

        System.out.println("插入的数据: "+count);

        // 默认不支持自动提交
        sqlSession.commit();

    }
}

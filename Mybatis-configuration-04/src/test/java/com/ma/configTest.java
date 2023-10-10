package com.ma;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * projectName: Mybatis-pratice
 * {@code @author: ma }
 * 2023 10 10 4:19 PM
 * description:
 */

public class configTest {

    // 环境变变量设置
    @Test
    public void testEnv() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "MAC");

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        sqlSession1.insert("insertNewCar");
        sqlSession1.commit();
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        sqlSession2.insert("insertNewCar");
        sqlSession2.commit();
        sqlSession2.close();
    }
}

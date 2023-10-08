package com.ma;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 美巴蒂斯完整测试
 *
 * @author ma
 * @date 2023/10/08
 *//* *
 * @packing com.ma
 * @author mtc
 * @date 16:06 10 08 16:06
 *
 */
public class MybatisCompleteTest {
    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.insert("insertCar");

        sqlSession.commit();


    }

}

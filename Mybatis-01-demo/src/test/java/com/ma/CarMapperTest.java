package com.ma;

import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/* *
 * @packing com.ma
 * @author mtc
 * @date 17:01 10 08 17:01
 *
 */
public class CarMapperTest {

    @Test
    public void testInsetCar() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.insert("insertCar");

        sqlSession.commit();


    }

    @Test
    public void testSqlSession(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.insert("insertCar");
        sqlSession.commit();
    }
}

package com.ma.test;

import com.ma.mapper.CarMapper;
import com.ma.pojo.Car;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * projectName: Mybatis-pratice
 * {@code @author: ma }
 * 2023 10 16 3:31 PM
 * description:
 */

public class testCarMapper {
    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(22129L, null, null, null, "sadad", "asdsdaaszxc");
        int result = sqlSessionMapper.updateBySet(car);
        System.out.println("result = " + result);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectByMultiConditionWithTrim(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = sqlSessionMapper.selectByMultiConditionWithTrim("", null, "");
        for (Car car : list){
            System.out.println(car);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectByMultiConditionWhere(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = sqlSessionMapper.selectByMultiConditionWhere("", null, "汽车");
        for (Car car : list){
            System.out.println(car);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectByMultiCondition(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = sqlSessionMapper.selectByMultiCondition("mi", null, "");
        // 三种分别为null 都可以
        for (Car car : list){
            System.out.println(car);
        }
        sqlSession.close();
    }
}

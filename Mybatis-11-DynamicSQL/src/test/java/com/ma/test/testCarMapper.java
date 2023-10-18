package com.ma.test;

import com.ma.mapper.CarMapper;
import com.ma.pojo.Car;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName: Mybatis-pratice
 * {@code @author: ma }
 * 2023 10 16 3:31 PM
 * description:
 */

public class testCarMapper {

    @Test
    public void testSelectById()
    {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Car car = sqlSessionMapper.selectById(1L);
        System.out.println("car = " + car);

    }

    @Test
    public void testDeleteByIds2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {2121L,2122L,2123L};
        int i = sqlSessionMapper.deleteByIds2(ids);
        System.out.println("result = " + i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(null,"123","比亚迪",7867D,"2012-12-09","汽车"));
        cars.add(new Car(null,"123","比亚迪",7867D,"2012-12-09","汽车"));
        cars.add(new Car(null,"123","比亚迪",7867D,"2012-12-09","汽车"));
        cars.add(new Car(null,"123","比亚迪",7867D,"2012-12-09","汽车"));
        cars.add(new Car(null,"123","比亚迪",7867D,"2012-12-09","汽车"));
        cars.add(new Car(null,"123","比亚迪",7867D,"2012-12-09","汽车"));
        cars.add(new Car(null,"123","比亚迪",7867D,"2012-12-09","汽车"));
        cars.add(new Car(null,"123","比亚迪",7867D,"2012-12-09","汽车"));

        int result = sqlSessionMapper.insertBatch(cars);
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
    }


    // 批量删除
    @Test
    public void testDeleteByIds(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {2118L,2119L,2120L};
        int i = sqlSessionMapper.deleteByIds(ids);
        System.out.println("result = " + i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByChoose(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = sqlSessionMapper.selectByChoose("", "", "");
        for (Car c : cars){
            System.out.println("car = " + c);;
        }
    }


    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(2L, null, null, null, "", "汽车");
        int result = sqlSessionMapper.updateBySet(car);
        System.out.println("result = " + result);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectByMultiConditionWithTrim(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = sqlSessionMapper.selectByMultiConditionWithTrim("", null, "汽车");
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

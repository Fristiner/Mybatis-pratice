package com.ma;

import com.ma.pojo.Car;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* *
 * @packing com.ma
 * @author mtc
 * @date 17:46 10 08 17:46
 *
 */
public class CarMapperTest {


    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();

        List<Car> all = sqlSession.selectList("selectAll");

        for(Car car : all){
            System.out.println(car);
        }




//        System.out.println(car);

        sqlSession.commit();
        sqlSession.close();
    }

    // 查询  根据id去查询
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();

        Car car = sqlSession.selectOne("selectById", 3);
        System.out.println(car);

        sqlSession.commit();
        sqlSession.close();


    }






    // 更新数据
    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(3L,"212","比亚迪",30.2,"2011-2-30","汽车");




        sqlSession.update("UpdateById",car);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();

        int deleteByid = sqlSession.delete("DeleteById", 5);

        System.out.println(deleteByid);


        sqlSession.commit();
        sqlSession.close();
    }


    // 命名空间的使用
    @Test
    public void testNamespace(){
        SqlSession sqlSession = SqlSessionUtil.openSession();



        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void testInsert() {

        // 使用map集合给sql语句传入值
        Map<String, Object> map = new HashMap<>();
        map.put("k1", "1111");
        map.put("k2", "11112");
        map.put("k3", "11113");
        map.put("k4", "11114");
        map.put("k5", "2020-11-21");
        map.put("k6", "电动车");

        SqlSession sqlSession = SqlSessionUtil.openSession();

        sqlSession.insert("insertCar", map);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsertCarByPOJO() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 封装数据

        Car car = new Car(null,"333","比亚迪",30.2,"2011-2-30","汽车");

    // 这里面找到的是 getXxxx(); 中的xxxx属性
        sqlSession.insert("InsertCarPojo", car);
        sqlSession.commit();
        sqlSession.close();
    }
}

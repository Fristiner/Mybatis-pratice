package com.ma.mapper;

import com.ma.pojo.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * projectName: Mybatis-pratice
 * {@code @author: ma }
 * 2023 10 16 9:02 PM
 * description:
 */

public interface CarMapper {

    @Insert("insert into t_car values (null,#{carNum},#{brand},#{guidePrice},#{produceTime},#{carType})")
    int insert(Car car);
    @Select("select * from t_car where id = #{id}")
    @Results({
            @Result(property = "carNum",column = "car_num"),
            @Result(property = "guidePrice",column = "guide_price"),
            @Result(property = "produceTime",column = "produce_time"),
            @Result(property = "carType",column = "car_type")
    })
    Car selectById(Long id);
}


package com.ma.mapper;

import com.ma.pojo.Car;

import java.util.List;

/* *
 * @packing com.ma.mapper
 * @author mtc
 * @date 13:18 10 15 13:18
 *
 */
public interface CarMapper {

    int insertCarUseGenerateKeys(Car car);


    /**
     * 按品牌选择， 模糊查询
     *
     * @param brand 品牌
     * @return 列表<汽车>
     */
    List<Car> selectByBrandLike(String brand);
}

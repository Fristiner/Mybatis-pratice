package com.ma.mapper;

import com.ma.pojo.Car;

import java.util.List;

/* *
 * @packing com.ma.mapper
 * @author mtc
 * @date 16:41 10 14 16:41
 *
 */
public interface CarMapper {
    /**
     * 插入
     *
     * @param car 汽车
     * @return int
     */
    int insert(Car car);

    /**
     * 按 ID 删除
     *
     * @param id 编号
     * @return int
     */
    int deleteById(Long id);

    /**
     * 更新
     *
     * @param car 汽车
     * @return int
     */
    int update(Car car);

    /**
     * 按 ID 选择
     *
     * @param id 编号
     * @return 汽车
     */
    Car selectById(Long id);

    /**
     * 全选
     *
     * @return 列表<汽车>
     */
    List<Car> selectAll();
}

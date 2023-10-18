package com.ma.mapper;

import com.ma.pojo.Car;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/* *
 * @packing com.ma.mapper
 * @author mtc
 * @date 16:07 10 15 16:07
 *
 */
public interface CarMapper {


    /**
     * 按 IDS2 删除
     * 按 ID 删除
     * 使用or 关键字
     * @param ids IDS
     * @return int
     */
    int deleteByIds2(@Param("ids") Long[] ids);


    Car selectById(Long id);

    /**
     * 插入批次
     *
     * @param cars 汽车
     * @return int
     */
    // 批量插入
    int insertBatch(@Param("cars") List<Car> cars);

    /**
     * 按 ID 删除 批量删除
     * foreach标签
     *
     * @param ids IDS
     * @return int
     */
    int deleteByIds(@Param("ids") Long[] ids);

    /**
     * 选择方式
     *
     * @param brand      品牌
     * @param guidePrice 指导价格
     * @param carType    车型
     * @return 列表<汽车>
     */
    List<Car> selectByChoose(@Param("brand") String brand,@Param("guidePrice") String guidePrice,@Param("carType") String carType);


    int updateBySet(Car car);
    /**
     * update by id
     *
     * @param car car
     * @return int
     */
    int updateById(Car car);

    /**
     * select by multi condition with trim
     *
     * @param brand      brand
     * @param guidePrice guide price
     * @param carType    car type
     * @return list<car>
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand,
                                          @Param("guidePrice")Double guidePrice,
                                          @Param("carType")String carType);



    /**
     * select by multi condition where
     * 使用where标签
     * @param brand      brand
     * @param guidePrice guide price
     * @param carType    car type
     * @return list<car>
     */
    List<Car> selectByMultiConditionWhere(@Param("brand") String brand,
                                     @Param("guidePrice")Double guidePrice,
                                     @Param("carType")String carType);

    /**
     * select by multi condition
     * 多条件查询
     * 根据 品牌 价格  汽车类型
     * if标签的使用
     * @param brand      brand
     * @param guidePrice guide price
     * @param carType    car type
     * @return list<car>
     */
    List<Car> selectByMultiCondition(@Param("brand") String brand,
                                     @Param("guidePrice")Double guidePrice,
                                     @Param("carType")String carType);
}

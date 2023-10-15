package com.ma.mapper;

import com.ma.pojo.Car;
import lombok.Value;
import org.apache.ibatis.annotations.MapKey;

import java.security.Key;
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
     * 查询所有的car信息
     * 使用resultMap标签进行结果映射
     *
     * @return 列表<汽车>
     */
    List<Car> selectAllByResultMap();



    // 返回一个更大的map
    // Map<String,Map>
    // 第二个map的主键值作为string 的值
    // 返回多个map集合
    // 谁作为大map集合里面的key
    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllMapById();


    List<Map<String,Object>> selectAllReturnListMap();



    // 返回map

    /**
     * 按返回地图选择
     * 返回一个map集合
     * @param id 编号
     * @return 映射<字符串 、 对象>
     */
    Map<String,Object> selectByReturnMap(Long id);
    //map =
    // {2112={car_num=2110, id=2112, guide_price=1431241, produce_time=2023-10-09, brand=西瓜准, car_type=国宝机甲},
    // 1={car_num=wojiu, id=1, guide_price=202, produce_time=2002-11-22, brand=nihao, car_type=汽车},
    // 2113={car_num=2110, id=2113, guide_price=1431241, produce_time=2023-10-09, brand=西瓜准, car_type=国宝机甲},
    // 2={car_num=wojiudddd, id=2, guide_price=202, produce_time=2002-11-22, brand=nihaaao, car_type=汽车},
    // 2114={car_num=ads, id=2114, guide_price=123, produce_time=sdaasd, brand=asdas, car_type=sdaasd},
    // 3={car_num=212, id=3, guide_price=30, produce_time=2011-2-30, brand=比亚迪, car_type=汽车},

    /**
     * 按 ID 选择 获取Car信息 返回一个和所有一样
     *
     * @param id 编号
     * @return 汽车
     *///
    Car selectById(Long id);
}

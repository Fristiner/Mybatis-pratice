package com.ma.mapper;

import com.ma.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/* *
 * @packing com.ma.mapper
 * @author mtc
 * @date 14:28 10 15 14:28
 *
 */
public interface StudentMapper {
    /**
     * 按姓名和性别选择
     * mybatis底层会自动创建一个map集合 ，并且map集合
     *  map.put("arg0",name);
     *  map.put("arg1",sex);
     *
     * @param name 名字
     * @param sex  性
     * @return 名单<学生>
     */
    // 传递多参数
    //
    /*
    * 告诉别人
    *  map.put("name",name)  告诉别人key的值 代替arg0 这种没有了 param1任然还有
    *
    * */
    List<Student> selectByNameAndSex2(@Param("name") String name,@Param(value = "sex") Character sex);

    List<Student> selectByNameAndSex( String name, Character sex);



    // 根据pojo来传值


    // 根据map来进行查询

    int insertStudentByMap(Map<String,Object> map);





    // 接口里面参数列表为一个/单个参数 且类型为简单类型
    // 根据id查询

    List<Student> selectById(Long id);

    List<Student> selectByName(String name);

    List<Student> selectByBirth(Date birth);

    List<Student> selectBySex(Character sex);

}

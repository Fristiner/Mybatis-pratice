package com.ma.mapper;

import com.ma.pojo.Stu;



/* *
 * @packing com.ma.mapper
 * @author mtc
 * @date 19:23 10 18 19:23
 *
 */
public interface StuMapper {

    /**
     * 按 ID 步骤1选择
     * TODO： 第三种方式
     *  两条SQL语句，分步查询
     *  优点
     *      1. 可复用性增强
     *      2. 可以充分利用延迟加载/懒加载机制
     *  延迟加载（懒加载）
     *      用到的时候在查询，不用的时候不查询。
     *      作用：提高性能。
     *  如何开启延迟加载
     *      association中加入 fetchType = "lazy"
     *      默认时不开启的
     *      是局部的设置 只对当前关联的ResultMap有用
     *      setting lazyLoadingEnabled
     *      不想用的全局默认开启 在特定的设置为eager
     *  按ID选择
     *
     * @param sid 希德
     * @return 斯图
     */
    Stu selectByIdStep1(Integer sid);

    /**
     * TODO：一条sql语句 Association方式
     *  选择 分布查询 第一步 根据学生id 查询学生信息
     * 按 ID 关联选择
     *
     * @param id 编号
     * @return 斯图
     */
    Stu selectByIdAssociation(Integer id);


    /*TODO：多对一
    *  1.级联属性映射
    *
    *
    * */
    /**
     * 按 ID 选择 同时获取学生关联的班级信息
     *
     * @param id 编号
     * @return 斯图
     */
    Stu selectById(Integer id);

}

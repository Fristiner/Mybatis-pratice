package com.ma.mapper;

import com.ma.pojo.Clazz;

/* *
 * @packing com.ma.mapper
 * @author mtc
 * @date 19:24 10 18 19:24
 *
 */
public interface ClazzMapper {
    /**
     * TODO： 分布查询第二步 根据cid 获取班级信息
     *  按 ID 选择
     *
     * @param cid 编号
     * @return 克拉兹
     */
    Clazz selectByIdStep2(Integer cid);

}

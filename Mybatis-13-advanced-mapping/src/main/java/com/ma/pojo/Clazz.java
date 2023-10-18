package com.ma.pojo;

import lombok.Data;

/**
 * 克拉兹
 *
 * @author ma
 * @date 2023/10/18
 *//* *
 * @packing com.ma.pojo
 * @author mtc
 * @date 19:18 10 18 19:18
 * 班级信息
 */
@Data
public class Clazz {
    private Integer cid;
    private String cname;

    public Clazz() {
    }

    public Clazz(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }
}

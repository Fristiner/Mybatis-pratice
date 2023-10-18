package com.ma.pojo;

import lombok.Data;

/* *
 * @packing com.ma.pojo
 * @author mtc
 * @date 19:19 10 18 19:19
 * 学生信息
 */
@Data
public class Stu {
    private Integer sid;
    private String sname;
    private Clazz clazz;

    
    public Stu(Integer sid, String sname, Clazz clazz) {
        this.sid = sid;
        this.sname = sname;
        this.clazz = clazz;
    }

    public Stu() {
    }

    public Stu(Integer sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }
}

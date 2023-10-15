package com.ma.pojo;

import lombok.Data;

import java.util.Date;

/* *
 * @packing com.ma.pojo
 * @author mtc
 * @date 14:26 10 15 14:26
 *
 */
@Data
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private Double height;
    private Date birth;
    private Character sex;

    public Student() {
    }

    public Student(Long id, String name, Integer age, Double height, Date birth, Character sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.birth = birth;
        this.sex = sex;
    }
}

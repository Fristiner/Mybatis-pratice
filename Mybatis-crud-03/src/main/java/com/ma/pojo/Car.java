package com.ma.pojo;

import lombok.Data;

/* *
 * @packing com.ma.pojo
 * @author mtc
 * @date 17:57 10 08 17:57
 *
 * 封装汽车相关信息的pojo类
 */
@Data
public class Car {
    // 数据库表当中的字段应该和pojo类的属性相对应
    // 使用包装类  防止null 问题
    private Long id;
    private String carNum;
    private Double guidePrice;
    private String Brand;
    private String produceTime;
    private String carType;


    public Car(Long id, String carNum, String Brand,Double guidePrice, String produceTime, String carType) {
        this.id = id;
        this.Brand = Brand;
        this.carNum = carNum;
        this.guidePrice = guidePrice;
        this.produceTime = produceTime;
        this.carType = carType;
    }

    public Car() {
    }


}

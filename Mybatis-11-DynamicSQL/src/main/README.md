# 动态SQL

## if标签
if标签中test是必须的   
test属性中的值必须为true|false  
test如果为true就会拼接  
test中只能使用and不能使用&&  
## where标签
自动生成如果没有内容where不会生效  
自动去掉and|or  
只能去掉前面的and  
## trim标签
prefix：在trim标签前添加内容
suffix：在trim标签中的语句后添加内容
prefixOverrides 前缀覆盖掉
suffixOverrides 后缀覆盖掉
```xml
select * from t_car
        <trim prefix="where" suffixOverrides="and">
            <if test="brand != null and brand != ''">
                 brand like "%"#{param1}"%" and
            </if>
            <if test="guidePrice != null and guidePrice != ''">
                 guide_price > #{guidePrice} and
            </if>
            <if test="carType!=null and carType != ''">
                car_type = #{carType}
            </if>
        </trim>
```


## choose when otherwise

```xml

<choose>
    <when test=""></when>
    <when test=""></when>
    <when test=""></when>
    <otherwise></otherwise>
</choose>
```




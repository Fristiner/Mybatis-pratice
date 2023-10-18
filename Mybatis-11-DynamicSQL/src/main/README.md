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

<choose>  // 相当于if
    <when test="s">
        
    </when> // 相当于else if 
    <when test="s">
        
    </when>
    <when test="s">
        
    </when>
    <otherwise>
        
    </otherwise>
</choose>

<select id="selectByChoose" resultType="com.ma.pojo.Car">
select * from t_car
<where>
    <choose>
        <when test="brand != null and brand!=''">
            brand like "%"#{brand}"%"
        </when>
        <when test="guidePrice != null and guidePrice != ''">
            guide_price > #{guidePrice}
        </when>
        <otherwise>
            car_type = #{carType}
        </otherwise>
    </choose>
</where>
```

## foreach标签
```xml
<!--    批量插入 一次插入多条信息-->
    <insert id="insertBatch">
        insert into t_car values
        <foreach collection="cars" item="car" separator=",">
            (null,#{car.carNum},#{car.brand},#{car.guidePrice},#{car.produceTime},#{car.carType})
        </foreach>
    </insert>

    <delete id="deleteByIds">
<!--     foreach 标签属性
            collection: 指定数组或者集合
            item: 代表数组或集合中的元素 变量名
            separator: 循环之间的分隔符
            底层一个map集合
            map.put("array", )
            map.put("arg0",)
-->
<!--         delete from t_car where id in(-->
<!--        <foreach collection="arg0"  item="id" separator=",">-->
<!--            #{id}-->
<!--        </foreach>-->
<!--        )-->
        delete from t_car where id in
        <foreach collection="ids" item="id" separator="," open="(" close=")">
            #{id}
        </foreach>
    </delete>
<!--    删除使用or -->
    <delete id="deleteByIds2">
        delete from t_car where
        <foreach collection="ids" item="id" separator="or">
            id = #{id}
        </foreach>
    </delete>
```

## include标签和sql标签

```xml
<!--    sql 标签 和 include标签-->
    <sql id="CarColumn">
        id,
        car_num as carNum,
        brand,
        guide_price as guidePrice,
        produce_time as produceTime,
        car_type as carType
    </sql>
    <select id="selectById" resultType="com.ma.pojo.Car">
        select
        <include refid="CarColumn"/>
        from t_car where id = #{id}
    </select>
```

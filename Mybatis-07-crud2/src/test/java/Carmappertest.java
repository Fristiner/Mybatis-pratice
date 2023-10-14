import com.ma.mapper.CarMapper;
import com.ma.pojo.Car;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/* *
 * @packing PACKAGE_NAME
 * @author mtc
 * @date 16:53 10 14 16:53
 *
 */
public class Carmappertest {



    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Car car = sqlSessionMapper.selectById(11L);
        System.out.println(car);
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> carList = sqlSessionMapper.selectAll();
        for (Car c:carList) {
            System.out.println(c);

        }
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Car car1 = new Car(11L, "2002", "奥特兰多汽车牌", 4156465.0,"2022-11-01","轿车");
        System.out.println(car1);
        int count = sqlSessionMapper.update(car1);
        // 更新后需要commit();
        sqlSession.commit();
        System.out.println(count);

    }

    @Test
    public void testInsert()
    {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car();
        car.setCarNum("2110");
        car.setGuidePrice(Double.valueOf("1431241"));
        car.setBrand("西瓜准");
        car.setProduceTime("2023-10-09");
        car.setCarType("国宝机甲");

//        car.setBrand("xiyanyang");
        car.setId(null);
        mapper.insert(car);
        sqlSession.commit();

    }

    @Test
    public void test11(){
        for (int i = 0; i < 10000; i++) {
            testInsert();
        }
    }
}

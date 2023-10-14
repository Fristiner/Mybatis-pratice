import com.ma.mapper.CarMapper;
import com.ma.pojo.Car;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/* *
 * @packing PACKAGE_NAME
 * @author mtc
 * @date 16:53 10 14 16:53
 *
 */
public class carMapperTest {
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
}

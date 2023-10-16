import com.ma.mapper.CarMapper;
import com.ma.pojo.Car;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * projectName: Mybatis-pratice
 * {@code @author: ma }
 * 2023 10 16 9:04 PM
 * description:
 */

public class TestCarMapper {

    @Test
    public void test02() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Car car = sqlSessionMapper.selectById(23136L);
        System.out.println("car = " + car);
    }


    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "1000", "比亚迪", 13245D, "2023-11-11", "汽车");
        int result = sqlSessionMapper.insert(car);
        System.out.println("result = " + result);
        sqlSession.commit();
        sqlSession.close();
    }
}

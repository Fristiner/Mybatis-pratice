import com.ma.mapper.CarMapper;
import com.ma.pojo.Car;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/* *
 * @packing PACKAGE_NAME
 * @author mtc
 * @date 13:21 10 15 13:21
 *
 */
public class testCarMapper {
    // 在插入数据时 自动获得自动生成的主键
    @Test
    public void testInsertCarUseGenerateKeys(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "ads", "asdas", 123.0, "sdaasd", "sdaasd");
        sqlSessionMapper.insertCarUseGenerateKeys(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        System.out.println(car.getId());

    }

    @Test
    public void testSelectLikeBrand(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = sqlSessionMapper.selectByBrandLike("ni");
        for(Car c : cars){
            System.out.println(c);
        }

    }
}

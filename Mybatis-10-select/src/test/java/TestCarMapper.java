import com.ma.mapper.CarMapper;
import com.ma.pojo.Car;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/* *
 * @packing PACKAGE_NAME
 * @author mtc
 * @date 16:09 10 15 16:09
 *
 */
public class TestCarMapper {
    // 总记录条数
    @Test
    public void testSelectCount(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Long a = sqlSessionMapper.selectCount();
        System.out.println("a = " + a);
    }


    // 驼峰映射
    @Test
    public void testSelectAllByCamel(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars =  sqlSessionMapper.selectAllByCamel();
        System.out.println(cars);
    }


    @Test
    public void testSelectAllMapById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Map<Long,Map<String,Object>> map = sqlSessionMapper.selectAllMapById();
        System.out.println("map = " + map);
    }

    // resultMap 对象关系映射
    @Test
    public void testSelectAllByResultMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars =   sqlSessionMapper.selectAllByResultMap();
        for(Car c : cars){
            System.out.println("car = " + c);
        }
    }


    @Test
    public  void  testSelectAllReturnListMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String,Object>>  map =sqlSessionMapper.selectAllReturnListMap();
        System.out.println("map = " + map);

    }


    @Test
    public void selectByReturnMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Map<String,Object> map = sqlSessionMapper.selectByReturnMap(1L);
        System.out.println(map.get("id"));
        System.out.println(map.get("car_num"));
        System.out.println("map = " + map);
//        for(Map<String,Object> map1:map)
//        {
//            System.out.println(map1);
//        }

    }


    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper sqlSessionMapper = sqlSession.getMapper(CarMapper.class);
        Car car = sqlSessionMapper.selectById(1L);
        System.out.println(car);

    }
}

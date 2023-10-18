import com.ma.mapper.StuMapper;
import com.ma.pojo.Clazz;
import com.ma.pojo.Stu;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/* *
 * @packing PACKAGE_NAME
 * @author mtc
 * @date 19:25 10 18 19:25
 *
 */
public class TestStuMapper {
    // 方法三： 分布查询
    @Test
    public void testSelectByIdStep() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StuMapper sqlSessionMapper = sqlSession.getMapper(StuMapper.class);
        Stu stu = sqlSessionMapper.selectByIdStep1(1);
        // 只是需要看学生的名字 不用第二个clazz 延迟加载
        System.out.println(stu.getSname());
        // 只执行一条sql语句

        System.out.println("stu = " + stu);
        sqlSession.close();
    }

    @Test
    public void testSelectByIdAssociation() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StuMapper sqlSessionMapper = sqlSession.getMapper(StuMapper.class);
        Stu stu = sqlSessionMapper.selectByIdAssociation(2);
        System.out.println("stu = " + stu);
        sqlSession.close();
    }


    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StuMapper sqlSessionMapper = sqlSession.getMapper(StuMapper.class);
        Stu stu = sqlSessionMapper.selectById(1);
        System.out.println(stu);
        Clazz clazz = stu.getClazz();
        System.out.println("clazz = " + clazz);

        sqlSession.close();
    }
}

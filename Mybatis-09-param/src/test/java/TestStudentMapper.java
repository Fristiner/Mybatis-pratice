import com.ma.mapper.StudentMapper;
import com.ma.pojo.Student;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* *
 * @packing PACKAGE_NAME
 * @author mtc
 * @date 14:31 10 15 14:31
 *
 */
public class TestStudentMapper {

    @Test
    public void testSelectByNameAndSex2() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper sqlSessionMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = sqlSessionMapper.selectByNameAndSex2("zhaoliu", '男');
        for (Student s:students){
            System.out.println(s);
        }
    }


    // 多参数传递
    @Test
    public void testSelectByNameAndSex() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper sqlSessionMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = sqlSessionMapper.selectByNameAndSex("zhaoliu", '男');
        for (Student s:students){
            System.out.println(s);
        }
    }
    //TODO 多参数传递值 底层是个map集合
    // arg0 and arg1 根据参数列表第一个和第二个来进行
    // param1 and param2  这两个时等效的
    // 相互之间混用也可以
    // 使用注解来解决这个问题



    @Test
    public void testInsertStudentByMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper sqlSessionMapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("姓名", "zhaoliu");

        hashMap.put("年龄", 20);
        hashMap.put("身高", 1.87);
        hashMap.put("性别", '男');
        hashMap.put("生日", new Date());
        int result = sqlSessionMapper.insertStudentByMap(hashMap);
        System.out.println("result = " + result);

        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper sqlSessionMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = sqlSessionMapper.selectById(1L);
        System.out.println(students);


    }
}

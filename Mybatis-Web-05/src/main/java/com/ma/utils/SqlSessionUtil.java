package com.ma.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/* *
 * @packing com.ma.utils
 * @author mtc
 * @date 17:21 10 08 17:21
 *
 */
public class SqlSessionUtil {

    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;

    // 工具类构造方法是私有化的
    // 工具类所有方法都是静态的
    // 类在进行第一次加载时运行
    //
    static {
        try {
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 全局的，一个服务器定义一个即可

    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    /**
     * 公开会话
     *
     * @return SQL 会话
     */
    public static SqlSession openSession(){

        SqlSession sqlSession = local.get();

        if (sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            // 绑定将sqlSession 对象绑定到当前线程上
            local.set(sqlSession);
        }

        return sqlSession;
    }

    // 关闭sqlSession 对象 从当前线程中移除sqlSession对象
    public static  void close(SqlSession sqlSession)
    {
        if (sqlSession != null){
            sqlSession.close();
            local.remove();
        }
    }

}

package com.ma.dao.impl;

import com.ma.dao.AccountDao;
import com.ma.pojo.Account;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * projectName: Mybatis-pratice
 * {@code @author: ma }
 * 2023 10 10 9:36 PM
 * description:
 */

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String arg0) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //        sqlSession.commit();
//        sqlSession.close();
        return (Account) sqlSession.selectOne("selectByActno", arg0);
    }

    @Override
    public int updateByActno(Account arg0) {
        SqlSession sqlSession = SqlSessionUtil.openSession();


        return sqlSession.update("updateByActno", arg0);
    }
}

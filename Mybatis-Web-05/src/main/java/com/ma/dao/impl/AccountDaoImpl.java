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
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = (Account) sqlSession.selectOne("selectByActno", actno);
//        sqlSession.commit();
//        sqlSession.close();
        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        int update = sqlSession.update("updateByActno", act);


        return update;
    }
}

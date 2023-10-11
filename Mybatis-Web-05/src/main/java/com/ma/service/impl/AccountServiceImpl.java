package com.ma.service.impl;

import com.ma.dao.impl.AccountDaoImpl;
import com.ma.exceptions.MoneyNotEnoughException;
import com.ma.exceptions.TransferException;
import com.ma.pojo.Account;
import com.ma.service.AccountService;
import com.ma.dao.AccountDao;
import com.ma.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author ma
 * @version 1.0.0
 * @data 2023/10/10
 * @className java.lang.String
 */

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();
    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //1.判断转出账号余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance()<money){
            // 2. 如果转出账户余额不足，提示用户
            throw new MoneyNotEnoughException("对不起余额不足");
        }
        // 3. 如果转出余额充足 更新转出账户余额
        // 先更新内存中java对象account的余额
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance()-money);
        toAct.setBalance(toAct.getBalance()+money);
        int count = accountDao.updateByActno(fromAct);
        // 更新数据
        // 4. 更新转入
        count += accountDao.updateByActno(toAct);
        if (count != 2){
            System.out.println("转账失败");
            throw new TransferException("转账异常，未知原因");
        }
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

    }
}

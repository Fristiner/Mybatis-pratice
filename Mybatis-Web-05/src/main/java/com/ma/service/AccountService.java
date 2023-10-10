package com.ma.service;

import com.ma.exceptions.MoneyNotEnoughException;
import com.ma.exceptions.TransferException;

/**
 * @author ma
 * @version 1.0.0
 * @data 2023/10/10
 * @className java.lang.String
 * 账户业务类
 */

public interface AccountService {
    /**
     * transfer
     *
     * @param fromActno 转出账号
     * @param toActno   转入账号
     * @param money     转账金额
     */
    void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, TransferException;

}

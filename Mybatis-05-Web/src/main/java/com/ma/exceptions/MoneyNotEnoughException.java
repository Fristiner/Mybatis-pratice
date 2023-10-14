package com.ma.exceptions;

/**
 * @author ma
 * @version 1.0.0
 * @data 2023/10/10
 * @className java.lang.String
 * 余额不足异常类
 */

public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(){}

    public MoneyNotEnoughException(String msg){
        super(msg);
    }
}

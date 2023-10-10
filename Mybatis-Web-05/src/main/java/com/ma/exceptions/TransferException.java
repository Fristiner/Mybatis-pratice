package com.ma.exceptions;

/**
 * @author ma
 * @version 1.0.0
 * @data 2023/10/10
 * @className java.lang.String
 * 转账异常失败
 */

public class TransferException extends Exception{
    public TransferException(){}
    public TransferException(String msg){
        super(msg);
    }

}

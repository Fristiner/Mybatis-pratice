package com.ma.dao;

import com.ma.pojo.Account;
import com.ma.utils.SqlSessionUtil;

/**
 * @author ma
 * @version 1.0.0
 * @data 2023/10/10
 * @className java.lang.String
 *  dao 没有任何业务逻辑在里面  进行crud的
 *   一般叫 insert select  update
 */

public interface AccountDao {
    /**
     * select by actno
     * 根据账号查询账户信息
     * @param actno actno
     * @return projectName:Mybatis-pratice
     */
    // 使用某个技术动态的生成dao借口的实现类
    Account selectByActno(String arg0);

    /**
     * update by actno
     * 更新账户信息
     * @param act act
     * @return int  1表示成功 其他值表示失败
     */
    int updateByActno(Account arg0);

}

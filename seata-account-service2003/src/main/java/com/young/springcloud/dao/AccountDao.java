package com.young.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 19:49
 * @Version: 1.0
 **/

@Mapper
public interface AccountDao {
    void decrease(@Param("userId") Long userId, @Param("money") Integer money);
}

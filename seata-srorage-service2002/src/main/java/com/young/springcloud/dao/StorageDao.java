package com.young.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 18:10
 * @Version: 1.0
 **/

@Mapper
public interface StorageDao {

   void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}

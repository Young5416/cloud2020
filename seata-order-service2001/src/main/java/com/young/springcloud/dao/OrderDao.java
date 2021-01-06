package com.young.springcloud.dao;
import com.young.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 12:46
 * @Version: 1.0
 **/

@Mapper
public interface OrderDao {
    int create(Order order);

    int update(@Param("userId")Long userId,@Param("status")Integer status);
}

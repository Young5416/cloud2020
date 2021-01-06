package com.young.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 12:42
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Long count;

    private BigDecimal money;

    private Integer status;
}

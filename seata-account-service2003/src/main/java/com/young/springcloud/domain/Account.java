package com.young.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Young
 * @create: 2021-01-06 19:48
 * @Version: 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;

    private Long userId;

    private Integer total;

    private Integer used;

    private Integer residue;
}

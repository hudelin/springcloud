package com.hu.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hudelin
 * @date 2020/12/4
 */
@AllArgsConstructor
public enum OrderStatusEnum {

    /**
     * 订单状态
     */
    ORDER_COMMIT("ORDER_COMMIT");

    @Getter
    private String name;
}

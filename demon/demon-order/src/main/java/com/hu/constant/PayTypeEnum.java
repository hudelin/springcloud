package com.hu.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hudelin
 * @date 2020-12-04
 */
@AllArgsConstructor
public enum PayTypeEnum {
    /**
     * 订单支付方式类型
     */
    ALI_PAY("1", "支付宝支付"),
    WX_PAY("2", "微信支付");

    @Getter
    private String payTypeId;

    @Getter
    private String name;

}

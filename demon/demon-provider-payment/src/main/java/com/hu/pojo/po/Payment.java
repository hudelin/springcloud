package com.hu.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : hudelin
 * @className :Payment
 * @description : 支付实体类
 * @date: 2020-06-30 15:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    private Long paymentId;

    private String serial;
}

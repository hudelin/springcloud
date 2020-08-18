package com.hu.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : hudelin
 * @className :PaymentBO
 * @description : 支付BO
 * @date: 2020-08-13 15:06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentBO {

    private Long paymentId;

    private String serial;
}

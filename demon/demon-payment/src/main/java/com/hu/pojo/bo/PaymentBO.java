package com.hu.pojo.bo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author : hudelin
 * @className :PaymentBO
 * @description : 支付BO
 * @date: 2020-08-13 15:06
 */
@Data
public class PaymentBO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long paymentId;

    private String serial;
}

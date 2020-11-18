package com.hu.pojo.vo;


import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PaymentPageVO extends PageVO{

    private String serial;

}

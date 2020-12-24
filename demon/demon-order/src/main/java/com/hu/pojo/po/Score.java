package com.hu.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

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
public class Score {

    private Long id;

    private String course;

    private Integer score;

    private String stuId;
}

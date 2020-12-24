package com.hu.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Lenovo
 */
@Data
@TableName(value = "demon_order")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DemonOrder extends BasePO {

    private String orderId;

    private String orderStatus;

}

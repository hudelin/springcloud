package com.hu.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author hudelin
 * @date 2021/3/2
 */
@Data
@TableName(value = "demon_product")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Product extends BasePO {

    private String productId;

    private String productName;

}

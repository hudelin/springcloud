package com.hu.pojo.vo;

import lombok.Data;


import javax.validation.constraints.NotNull;

/**
 * @author hudelin
 * @date 2020-12-24
 */
@Data
public class PageVO {

    @NotNull(message = "字段,current,当前页码不能为空")
    Integer current;

    @NotNull(message = "字段,size,页数不能为空")
    Integer size;
}

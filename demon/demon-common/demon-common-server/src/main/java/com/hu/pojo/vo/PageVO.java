package com.hu.pojo.vo;

import lombok.Data;


import javax.validation.constraints.NotNull;

@Data
public class PageVO {

    @NotNull(message = "当前页码不能为空")
    Integer current;

    @NotNull(message = "页数不能为空")
    Integer size;
}

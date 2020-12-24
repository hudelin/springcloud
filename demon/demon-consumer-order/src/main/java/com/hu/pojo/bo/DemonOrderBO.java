package com.hu.pojo.bo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author hudelin
 * @date 2020/12/23
 */
@Data
public class DemonOrderBO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String orderId;

    private String orderStatus;
}

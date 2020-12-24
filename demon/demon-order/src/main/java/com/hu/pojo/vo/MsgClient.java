package com.hu.pojo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hudelin
 * @date 2020/12/10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgClient {

    @Excel(name = "ID")
    private String id;

    @Excel(name = "客户名")
    private String clientName;

    @Excel(name = "客户手机号")
    private String clientPhone;

    @Excel(name = "生日")
    private Date birthday;

    @Excel(name = "备注")
    private String remark;

    @Excel(name = "创建人")
    private String createBy;

}

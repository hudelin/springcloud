package com.hu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hu.pojo.bo.DemonOrderBO;
import com.hu.pojo.po.DemonOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author hudelin
 * @date 2020/12/4
 */
public interface OrderMapper extends BaseMapper<DemonOrder> {

    @Select("SELECT id,order_id,order_status FROM demon_order ${ew.customSqlSegment} ")
    Page<DemonOrderBO> selectPage1(Page<DemonOrder> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}

package com.example.orderget.mapper;

import com.example.orderget.po.SaleOrder;
import com.example.orderget.po.SaleOrderLine;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author zhangxu
 * @create 2023-11-10
 */
@Repository
public interface SaleOrderLineMapper extends MySqlMapper<SaleOrderLine>,Mapper<SaleOrder> {
    public List<SaleOrderLine> getOrderAndOrderLineByOrderId(String id);
}

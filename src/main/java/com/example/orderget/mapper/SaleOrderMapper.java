package com.example.orderget.mapper;

import com.example.orderget.po.SaleOrder;
import com.example.orderget.po.SaleOrderLine;
import com.example.orderget.po.SaleOrderVO;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author zhangxu
 * @create 2023-11-10
 */
@Repository
public interface SaleOrderMapper extends MySqlMapper<SaleOrder>, Mapper<SaleOrder> {
    public SaleOrderVO getOrderAndLinesById(String id);
    public List<SaleOrder> getAllOrder();
}

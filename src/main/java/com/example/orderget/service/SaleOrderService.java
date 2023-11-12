package com.example.orderget.service;

import com.example.orderget.po.SaleOrder;
import com.example.orderget.po.SaleOrderVO;

import java.util.List;


/**
 * @author zhangxu
 * @create 2023-11-10
 */

public interface SaleOrderService{
    public List<SaleOrder> getAllOrder();
    public SaleOrderVO getOrderById(String id);
}
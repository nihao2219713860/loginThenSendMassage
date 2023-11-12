package com.example.orderget.service.impl;

import com.example.orderget.mapper.SaleOrderMapper;
import com.example.orderget.po.SaleOrder;
import com.example.orderget.po.SaleOrderVO;

import com.example.orderget.service.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author zhangxu
 * @create 2023-11-10
 */
@Service
public class SaleOrderServiceImpl implements SaleOrderService {
    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @Override
    public List<SaleOrder> getAllOrder() {
        List<SaleOrder> saleorders = saleOrderMapper.getAllOrder();
        Iterator<SaleOrder> iterator = saleorders.iterator();
        for (int i = 0; i < saleorders.size(); i++) {
            System.out.println(iterator.next());
        }
        return saleorders;
    }

    @Override
    public SaleOrderVO getOrderById(String id) {
        SaleOrderVO saleOrderVO = saleOrderMapper.getOrderAndLinesById(id);
        return saleOrderVO;
    }
}

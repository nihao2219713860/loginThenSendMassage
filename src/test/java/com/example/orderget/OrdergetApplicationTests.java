package com.example.orderget;

import com.example.orderget.mapper.SaleOrderLineMapper;
import com.example.orderget.mapper.SaleOrderMapper;
import com.example.orderget.po.SaleOrder;
import com.example.orderget.po.SaleOrderVO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrdergetApplicationTests {

    @Autowired
    private SaleOrderMapper saleOrderMapper;
    @Autowired
    private SaleOrderLineMapper saleOrderLineMapper;

    @Test
    public void test() {
        SaleOrderVO orderAndLinesById = saleOrderMapper.getOrderAndLinesById("1");
        System.out.println(orderAndLinesById.toString());
    }
    @Test
    public void getAllOrder() {
        {
            List<SaleOrder> saleorders = saleOrderMapper.getAllOrder();
            System.out.println(saleorders);
            for (SaleOrder s : saleorders) {
                String id = s.getId();
                System.out.println(s);
            }
        }
    }
}

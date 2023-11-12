package com.example.orderget.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleOrderLine {
    private String id;
    private String orderid;
    private Integer lineno;
    //商品
    private String material;
    //数量
    private Double qty;

}

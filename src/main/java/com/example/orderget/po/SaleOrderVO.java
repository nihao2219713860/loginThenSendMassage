package com.example.orderget.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* 
* @TableName saleorder
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleOrderVO implements Serializable {
    private String id;
    private Date createdon;
    private Integer linenum;
    private String remark;
    private List<SaleOrderLine> saleorderlines;

}

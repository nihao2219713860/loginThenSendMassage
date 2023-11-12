package com.example.orderget.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
* 
* @TableName saleorder
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleOrder implements Serializable {
    private String id;
    private Date createdon;
    private Integer linenum;
    private String remark;


}

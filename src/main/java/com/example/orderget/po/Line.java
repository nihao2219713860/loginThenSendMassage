package com.example.orderget.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangxu
 * @create 2023-11-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Line {
    private String part;
    private String expectedQty=null;
    private double actualQty;
    private String lotNo="";
    public Line(String part,double actualQty){
        this.part=part;
        this.actualQty=actualQty;
    }

}

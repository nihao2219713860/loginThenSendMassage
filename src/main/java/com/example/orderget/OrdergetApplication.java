package com.example.orderget;

import com.example.orderget.po.SaleOrder;
import com.example.orderget.po.SaleOrderVO;
import com.example.orderget.service.SaleOrderService;
import com.example.orderget.service.SystemService;
import org.apache.http.client.CookieStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@MapperScan("com.example.orderget.mapper")
@EnableScheduling
public class OrdergetApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdergetApplication.class, args);
    }
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SystemService systemService;

    private Logger logger = LoggerFactory.getLogger(OrdergetApplication.class);
    @Scheduled(cron = "0 00 02 * * ?")
    void getOrderAll() {
        String loginUrl = "http://localhost:8880/api/sign-in";
        String sendUrl="http://localhost:8880/api/inbound/create";
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "admin");
        logger.info("开始登录");
        CookieStore cookieStore = systemService.loginStoreCookie(loginUrl, map);
        logger.info("登录完成");
        //查询数据库的数据
        logger.info("开始查询数据库中所有的订单。。。。");
        List<SaleOrder> allOrder = saleOrderService.getAllOrder();
        logger.info("查询完成");
        List<SaleOrderVO> list = new ArrayList<>();
//       将数据封装
        for (SaleOrder order : allOrder) {
            String id = order.getId();
            logger.info("开始查询订单的单行");
            SaleOrderVO orderAndLines = saleOrderService.getOrderById(id);
            logger.info("开始查询订单的单行完成");
//            以id为key，每一次传输的数据为value
            list.add(orderAndLines);
        }
        logger.info("开始逐个订单上传系统。。");
        Integer number = systemService.sendOneByOne(sendUrl, list, cookieStore);
        logger.info("上传完成"+number+"个");

    }
}

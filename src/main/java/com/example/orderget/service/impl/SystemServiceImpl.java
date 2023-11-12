package com.example.orderget.service.impl;

import com.example.orderget.po.Line;
import com.example.orderget.po.SaleOrder;
import com.example.orderget.po.SaleOrderLine;
import com.example.orderget.po.SaleOrderVO;
import com.example.orderget.service.SystemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @author zhangxu
 * @create 2023-11-12
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Override
    public CookieStore loginStoreCookie(String httpUrl, Map paramMap) {
//        第一步、基础数据
        ObjectMapper objectMapper = new ObjectMapper();
//       第三步、创建httpclient客户端
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
//       第四步、编辑post请求方法的参数
        try {
            HttpPost httpPost = new HttpPost(httpUrl);
            httpPost.setHeader("Content-Type", "application/json");
            String jsonString = objectMapper.writeValueAsString(paramMap);
            StringEntity entity = new StringEntity(jsonString);
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("登录成功！");
                return cookieStore;
            } else {
                System.out.println("登录失败：");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public Integer sendOneByOne(String httpUrl, List<SaleOrderVO> list, CookieStore cookieStore) {
        ObjectMapper objectMapper = new ObjectMapper();
        Integer successNumber = 0;
//        第一步，拿到cookie后可以创建httpclient对象
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
//        第二步，创建post请求
        HttpPost httpPost = new HttpPost(httpUrl);
//        第三步，设置post请求的参数
        String jsonString = null;
//        创建请求正文的数据结构
        HashMap<String, Object> sendMap = new HashMap<>();
//      对传入的数据进行数据结构的转换

        try {
            for (SaleOrderVO orderAndlines : list) {
//            构建order相关的数据结构，并且放入
                Map orderMap = new HashMap();
                orderMap.put("state", 0);
                orderMap.put("remark", orderAndlines.getRemark());
                orderMap.put("template", "料箱入库");
                sendMap.put("order", orderMap);
//            构建lines相关的数据结构放入
                HashMap<String, List> lines = new HashMap<>();
                List<SaleOrderLine> saleorderlines = orderAndlines.getSaleorderlines();
                List<Line> lineList = new ArrayList<>();
                for (SaleOrderLine saleorderline : saleorderlines) {
                    lineList.add(new Line(saleorderline.getMaterial(), saleorderline.getQty()));
                }
                lines.put("lines", lineList);
                successNumber++;
            }
//        关闭资源
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return successNumber;
    }


}

package com.example.orderget.service;

import com.example.orderget.po.SaleOrderVO;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.mybatis.logging.LoggerFactory;
import org.apache.http.cookie.Cookie;
import org.springframework.util.StringUtils;


import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangxu
 * @create 2023-11-12
 */
public interface SystemService {
    /**
     * @des 登录后获取到cookie并且存储
     * @param httpUrl
     * @param paramMap
     * @return cookie
     */
    CookieStore cookieStore = new BasicCookieStore();

    CookieStore loginStoreCookie(String httpUrl, Map paramMap);
    public Integer sendOneByOne(String httpUrl, List<SaleOrderVO> list, CookieStore cookieStore);
}


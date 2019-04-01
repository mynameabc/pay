package com.service.order;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderProxyService")
public class OrderProxyService implements IOrder {

    @Autowired
    private IOrder orderService;


    /**
     * 支付接口
     * @param domainName
     * @param clientIP
     * @param port
     * @param params
     */
    public void pay(String domainName, String clientIP, int port, JSONObject params) {

        boolean isvalue = whiteListIsExist(domainName, clientIP, port);
        if (isvalue) {
            orderService.pay(domainName, clientIP, port, params);
        }
    }

    /**
     * 客户端IP 端口号 域名是否匹配
     * @param domainName
     * @param clientIP
     * @param port
     * @return
     */
    private boolean whiteListIsExist(String domainName, String clientIP, int port) {

        boolean isvalue = false;


        return isvalue;
    }
}

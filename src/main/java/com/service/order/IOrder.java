package com.service.order;

import com.alibaba.fastjson.JSONObject;

public interface IOrder {

    /**
     * 支付接口
     * @param domainName
     * @param clientIP
     * @param port
     * @param params
     */
    void pay(String domainName, String clientIP, int port, JSONObject params);
}

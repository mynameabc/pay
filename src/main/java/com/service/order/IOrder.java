package com.service.order;

import com.alibaba.fastjson.JSONObject;
import com.utils.Result;

public interface IOrder {

    /**
     * 支付接口
     * @param domainName
     * @param clientIP
     * @param port
     * @param params
     */
    Result pay(String domainName, String clientIP, int port, JSONObject params);
}

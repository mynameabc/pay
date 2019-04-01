package com.service.order;

import com.alibaba.fastjson.JSONObject;
import com.utils.Result;
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
    public Result pay(String domainName, String clientIP, int port, JSONObject params) {

        Result result = whiteListIsExist(domainName, clientIP, port);
        if (result.isSuccess()) {
            return orderService.pay(domainName, clientIP, port, params);
        } else {
            return result;
        }
    }

    /**
     * 客户端IP 端口号 域名是否匹配
     * @param domainName
     * @param clientIP
     * @param port
     * @return
     */
    private Result whiteListIsExist(String domainName, String clientIP, int port) {

        Result result = null;


        return result;
    }
}

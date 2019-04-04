package com.service.order;

import com.alibaba.fastjson.JSONObject;
import com.entity.Order;
import com.entity.dto.OrderDTO;
import com.utils.Result;

public interface IOrder {

    /**
     * 支付接口
     * @param domainName
     * @param clientIP
     * @param port
     * @param orderDTO
     */
    Result pay(String domainName, String clientIP, String port, OrderDTO orderDTO);
}

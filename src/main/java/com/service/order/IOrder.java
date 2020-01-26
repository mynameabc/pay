package com.service.order;

import com.pojo.dto.OrderDTO;
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

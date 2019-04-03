package com.service.order;

import com.entity.ClientIPWhite;
import com.entity.dto.OrderDTO;
import com.mapper.ClientIPWhiteMapper;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderClientIPWhiteProxyService")
public class OrderClientIPWhiteProxyService implements IOrder {

    @Autowired
    @Qualifier("orderService")
    private IOrder orderService;

    @Autowired
    private ClientIPWhiteMapper clientIPWhiteMapper;


    /**
     * 支付接口
     * @param domainName
     * @param clientIP
     * @param port
     * @param orderDTO
     */
    @Transactional
    public Result pay(String domainName, String clientIP, int port, OrderDTO orderDTO) {

        Result result = whiteListIsExist(domainName, clientIP, orderDTO);
        if (result.isSuccess()) {
            return orderService.pay(domainName, clientIP, port, orderDTO);
        } else {
            return result;
        }
    }

    /**
     * 客户端IP 端口号 域名是否匹配
     * @param domainName
     * @param clientIP
     * @return
     */
    private Result whiteListIsExist(String domainName, String clientIP, OrderDTO orderDTO) {

        int count = clientIPWhiteMapper.getClientIPWhiteCount(clientIP, orderDTO.getMchOrderID());
        if (count >= 1) {
            return new Result(true, "白名单匹配成功!");
        }

        return new Result(false, "白名单匹配失败!");
    }
}

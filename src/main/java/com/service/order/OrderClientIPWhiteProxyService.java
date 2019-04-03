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

        Result result = whiteListIsExist(domainName, clientIP, port);
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
     * @param port
     * @return
     */
    private Result whiteListIsExist(String domainName, String clientIP, int port) {

        Result result = new Result(true, "SUCCESS");

        ClientIPWhite clientIPWhite = new ClientIPWhite();
        int count = clientIPWhiteMapper.selectCount(clientIPWhite);


        return result;
    }
}

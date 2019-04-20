package com.service.order;

import com.entity.ClientIPWhite;
import com.entity.dto.OrderDTO;
import com.mapper.ClientIPWhiteMapper;
import com.utils.Result;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("orderClientIPWhiteProxyService")
public class OrderClientIPWhiteProxyService implements IOrder {

    final static Logger logger = LogManager.getLogger(OrderClientIPWhiteProxyService.class);

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
    public Result pay(String domainName, String clientIP, String port, OrderDTO orderDTO) {

        Result result = whiteListIsExist(domainName, clientIP, port, orderDTO);
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
    private Result whiteListIsExist(String domainName, String clientIP, String port, OrderDTO orderDTO) {

        ClientIPWhite clientIPWhite = null;

        try {
            clientIPWhite = clientIPWhiteMapper.getClientIPWhite(clientIP, orderDTO.getMchID());
        } catch (Exception e) {
            logger.error("Bad this:", e);
        }

        if (null != clientIPWhite) {

            //如果表中的端口号不为空
            if (!StringUtils.isEmpty(clientIPWhite.getPort())) {

                //匹配端口号
                if (!port.equals(clientIPWhite.getPort().trim())) {
                    return new Result(false, "端口号匹配失败, 发送请求的端口号:" + port);
                }
            }

        } else {

            return new Result(false, "IP地址匹配失败, 发送请求的IP:" + clientIP);
        }

        logger.info("info");
        logger.warn("warn");
        logger.debug("debug");
        logger.error("error");
        return new Result(true, "白名单匹配成功!");
    }
}
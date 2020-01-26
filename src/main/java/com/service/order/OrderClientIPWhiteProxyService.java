package com.service.order;

import com.pojo.entity.IPWhite;
import com.pojo.dto.OrderDTO;
import com.mapper.ClientIPWhiteMapper;
import com.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
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

        IPWhite clientIPWhite = null;

        try {
            clientIPWhite = clientIPWhiteMapper.getClientIPWhite(clientIP, orderDTO.getMchID());
        } catch (Exception e) {
            log.error("Bad this:", e);
        }

        if (null != clientIPWhite) {

            //如果表中的端口号不为空
/*            if (!StringUtils.isEmpty(clientIPWhite.getPort())) {

                //匹配端口号
                if (!port.equals(clientIPWhite.getPort().trim())) {
                    return new Result(false, "端口号匹配失败, 发送请求的端口号:" + port);
                }
            }*/

        } else {

            return new Result(false, "IP地址匹配失败, 发送请求的IP:" + clientIP);
        }

        log.info("info");
        log.warn("warn");
        log.debug("debug");
        log.error("error");
        return new Result(true, "白名单匹配成功!");
    }
}

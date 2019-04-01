package com.service.order;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service("orderService")
class OrderService implements IOrder {

    /**
     * 支付接口
     * @param domainName
     * @param clientIP
     * @param port
     * @param params
     */
    public void pay(String domainName, String clientIP, int port, JSONObject params) {

        String mchId = params.getString("mchId");
        this.validateMerchant(mchId, clientIP, port);
    }

    private void validateMerchant(String merchantID, String clientIP, int port) {

        //校验IP和端口号是否在白名单内
        {

        }

        //查看商户
        {

            //商户产品
            {
                //商户提交的产品ID是否存在
                {

                }

                //商户提交的产品ID是否已开通
                {

                }
            }

            //商户提交金额
            {
                //商户提交的金额是否超过额度
                {

                }

                //商户所提交金额是否符合平台规则
                {

                }

                //商户所提交金额是否符合商户自己的规则
                {

                }

                //商户所提交金额是否符合其提交的通道实例规则
                {

                }
            }
        }
    }
}

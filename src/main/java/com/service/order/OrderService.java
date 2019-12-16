package com.service.order;

import com.entity.Merchant;
import com.entity.dto.OrderDTO;
import com.mapper.MerchantMapper;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
class OrderService implements IOrder {

    @Autowired
    private MerchantMapper merchantMapper;

    /**
     * 支付接口
     * @param domainName
     * @param clientIP
     * @param port
     * @param orderDTO
     */
    public Result pay(String domainName, String clientIP, String port, OrderDTO orderDTO) {

        long mchId = orderDTO.getMchID();
        Result result = this.validateMerchant(mchId, clientIP, port);
        if (!result.isSuccess()) {
            return result;
        }

        {

        }

        return result;
    }

    private Result validateMerchant(long merchantID, String clientIP, String port) {

        //查看商户
        {

            //商户是否存在
            {
                Merchant merchant = merchantMapper.selectByPrimaryKey(merchantID);
                if (null == merchant) {
                    return new Result(true, "", null);
                }
            }

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

                //商户所提交金额是否符合其提交的通道实例规则
                {

                }
            }
        }

        return new Result(true, "", null);
    }
}

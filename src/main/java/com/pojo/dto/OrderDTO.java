package com.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value="orderDTO")
public class OrderDTO implements java.io.Serializable {

    private static final long serialVersionUID = 4499893593775144083L;

    @ApiModelProperty(value="商户号", name="mchID", required=true)
    private long mchID;

    @ApiModelProperty(value="商户订单号", name="mchOrderID", required=true)
    private String mchOrderID;

    @ApiModelProperty(value="订单时间", name="dateTime", required=true, example="yyyy-MM-dd HH:mm:ss")
    private String dateTime;

    @ApiModelProperty(value="订单金额(单位:分)", name="orderAmount", required=true, example="100")
    private BigDecimal orderAmount;

    @ApiModelProperty(value="支付金额(单位:分)", name="payAmount", required=true, example="100")
    private BigDecimal payAmount;

    @ApiModelProperty(value="异步通知地址", name="notifyURL", required=true, example="http://域名或IP:端口号/")
    private String notifyURL;

    @ApiModelProperty(value="签名", name="sign", required=true, example="C380BEC2BFD727A4B6845133519F3AD6")
    private String sign;

    public OrderDTO(){}
}

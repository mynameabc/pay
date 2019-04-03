package com.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel(value="orderDTO")
public class OrderDTO implements java.io.Serializable {

    private static final long serialVersionUID = 4499893593775144083L;

    @ApiModelProperty(value="商户号", name="mchID", required=true, example="2192969890764444837")
    private long mchID;

    @ApiModelProperty(value="商户订单号", name="mchOrderID", required=true)
    private long mchOrderID;

    @ApiModelProperty(value="订单金额(单位:分)", name="orderAmount", required=true, example="100")
    private BigDecimal orderAmount;

    @ApiModelProperty(value="支付金额(单位:分)", name="payAmount", required=true, example="100")
    private BigDecimal payAmount;

    @ApiModelProperty(value="异步通知地址", name="notifyURL", required=true, example="http://域名或IP:端口号/")
    private String notifyURL;

    @ApiModelProperty(value="签名", name="sign", required=true, example="C380BEC2BFD727A4B6845133519F3AD6")
    private String sign;

    public OrderDTO(){}

    public long getMchID() {
        return mchID;
    }

    public void setMchID(long mchID) {
        this.mchID = mchID;
    }

    public long getMchOrderID() {
        return mchOrderID;
    }

    public void setMchOrderID(long mchOrderID) {
        this.mchOrderID = mchOrderID;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getNotifyURL() {
        return notifyURL;
    }

    public void setNotifyURL(String notifyURL) {
        this.notifyURL = notifyURL;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}

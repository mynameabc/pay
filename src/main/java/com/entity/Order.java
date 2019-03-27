package com.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "order")
public class Order implements java.io.Serializable {

    private static final long serialVersionUID = -2192969890764444837L;

    @Id
    @Column(name = "orderID")
    private long orderID;

    @Column(name = "merchantID")
    private long merchantID;

    @Column(name = "orderAmount")
    private BigDecimal orderAmount;

    @Column(name = "payAmount")
    private BigDecimal payAmount;

    @Column(name = "status")
    private int status;

    @Column(name = "notifyURL")
    private String notifyURL;

    @Column(name = "returnURL")
    private String returnURL;

    @Column(name = "sign")
    private String sign;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "payingTime")
    private Date payingTime;

    @Column(name = "payTime")
    private Date payTime;

    @Column(name = "solvedTime")
    private Date solvedTime;

    @Column(name = "expireTime")
    private Date expireTime;

    @Column(name = "domainName")
    private String domainName;

    @Column(name = "clientIP")
    private String clientIP;

    public Order() {}

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(long merchantID) {
        this.merchantID = merchantID;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNotifyURL() {
        return notifyURL;
    }

    public void setNotifyURL(String notifyURL) {
        this.notifyURL = notifyURL;
    }

    public String getReturnURL() {
        return returnURL;
    }

    public void setReturnURL(String returnURL) {
        this.returnURL = returnURL;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayingTime() {
        return payingTime;
    }

    public void setPayingTime(Date payingTime) {
        this.payingTime = payingTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getSolvedTime() {
        return solvedTime;
    }

    public void setSolvedTime(Date solvedTime) {
        this.solvedTime = solvedTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }
}

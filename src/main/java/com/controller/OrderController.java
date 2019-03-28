package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.order.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags="订单支付模块")
@RestController
@EnableAutoConfiguration
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value="提交订单", notes="给下游方调用的订单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="body", dataType="Model", name="params", value = "信息参数", required = true)
    })
    @PostMapping(value="/pay", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public String downStreamPay(@RequestBody String params, HttpServletRequest request) {

        int port = request.getRemotePort();             //端口号
        String clientIP = getIpAddress(request);        //真实IP地址
        String domainName = request.getServerName();    //域名

        try {
            orderService.pay(domainName, clientIP, port, JSONObject.parseObject(params));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "支付接口";
    }

    @ApiOperation(value="支付回调地址", notes="给上游方调用的回调地址")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path", dataType="long", name="orderID", value = "订单ID", required = true)
    })
    @GetMapping(value="/notify/{orderID}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String upStreamNotify(@PathVariable long orderID) {
        System.out.println(orderID);
        return "支付回调地址";
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     *
     * 用户真实IP为： 192.168.1.110
     *
     * @param request
     * @return
     */
    private static String getIpAddress(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}

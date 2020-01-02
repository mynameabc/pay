package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.dto.OrderDTO;
import com.service.order.IOrder;
import com.utils.Result;
import com.utils.SignUtil;
import com.utils.log.MyLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Api(tags="订单支付")
@RestController
@EnableAutoConfiguration
public class PayOrderController {

    @Autowired
    @Qualifier("orderClientIPWhiteProxyService")
    private IOrder orderClientIPWhiteProxyService;

    @ApiOperation(value="统一下单接口", notes="统一下单接口")
    @RequestMapping(value="/pay", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Result pay(@RequestParam String params, HttpServletRequest request) {

        String logPrefix = "【商户统一下单接口】";
        log.info("{}请求参数:{}", logPrefix, params);

        int port = request.getRemotePort();             //端口号
        String clientIP = getIpAddress(request);        //真实IP地址
        String domainName = request.getServerName();    //域名

        Result result = null;

        //验证IP
        //验证参数
        JSONObject po = JSONObject.parseObject(params);
        JSONObject object = JSONObject.parseObject(this.validateParams(po).toString());

        //验证商户号是否存在
        //验证商户账户是否有钱
        //验证商户是否有可用通道

/*
        if (!result.isSuccess()) {
            _log.info("{}参数校验不通过:{}", logPrefix, object);
            return XXPayUtil.makeRetFail(XXPayUtil.makeRetMap(PayConstant.RETURN_VALUE_FAIL, object.toString(), null, PayEnum.ERR_0014.getCode(), object.toString()));
        }*/

        //创建订单

        //根据产品ID获取相关类实例

        //执行pay方法
        try {
//            result = orderClientIPWhiteProxyService.pay(domainName, clientIP, String.valueOf(port), orderDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //根据结果返回相关信息

        return result;
    }

    /**
     * 验证
     * @return
     */
    private Object validate() {
        return null;
    }

    /**
     * 验证创建订单请求参数,参数通过返回JSONObject对象,否则返回错误文本信息
     * @param params
     * @return
     */
    private Object validateParams(JSONObject params) {
/*

        String riskLog = "[风控]";

        // 验证请求参数,参数有问题返回错误提示
        String errorMessage;

        // 支付参数
        String mchId = params.getString("mchId"); 			    // 商户ID
        String appId = params.getString("appId");              // 应用ID
        String productId = params.getString("productId");      // 支付产品ID
        String mchOrderNo = params.getString("mchOrderNo"); 	// 商户订单号
        String amount = params.getString("amount"); 		    // 支付金额（单位分）
        String currency = params.getString("currency");        // 币种
        String clientIp = params.getString("clientIp");	    // 客户端IP
        String device = params.getString("device"); 	        // 设备
        String extra = params.getString("extra");		        // 特定渠道发起时额外参数
        String param1 = params.getString("param1"); 		    // 扩展参数1
        String param2 = params.getString("param2"); 		    // 扩展参数2
        String notifyUrl = params.getString("notifyUrl"); 		// 支付结果回调URL
        String sign = params.getString("sign"); 				// 签名
        String subject = params.getString("subject");	        // 商品主题
        String body = params.getString("body");	            // 商品描述信息

        // 验证请求参数有效性（必选项）
        Long mchIdL;
        if(StringUtils.isBlank(mchId) || !NumberUtils.isDigits(mchId)) {
            errorMessage = "请求参数[mchId]不能为空且为数值类型.";
            return errorMessage;
        }
        mchIdL = Long.parseLong(mchId);


        Integer productIdI = null;
        if(StringUtils.isBlank(productId) || !NumberUtils.isDigits(productId)) {
            errorMessage = "请求参数[productId]不能为空且为数值类型.";
            return errorMessage;
        }
        productIdI = Integer.parseInt(productId);

        if(StringUtils.isBlank(mchOrderNo)) {
            errorMessage = "请求参数[mchOrderNo]不能为空.";
            return errorMessage;
        }

        if(!NumberUtils.isDigits(amount)) {
            errorMessage = "请求参数[amount]应为数值类型.";
            return errorMessage;
        }
        Long amountL = Long.parseLong(amount);
//        if(!mchId.equals("20000004") && !mchId.equals("20000005")) {
//            if (amountL <= 10000) {
//                errorMessage = "请求参数[amount]必须大于10000.";
//                return errorMessage;
//            }
//        }
        if(StringUtils.isBlank(currency)) {
            errorMessage = "请求参数[currency]不能为空.";
            return errorMessage;
        }
        if(StringUtils.isBlank(notifyUrl)) {
            errorMessage = "请求参数[notifyUrl]不能为空.";
            return errorMessage;
        }
        if(StringUtils.isBlank(subject)) {
            errorMessage = "请求参数[subject]不能为空.";
            return errorMessage;
        }
        if(StringUtils.isBlank(body)) {
            errorMessage = "请求参数[body]不能为空.";
            return errorMessage;
        }
        String channelUser = "";


        // 签名信息
        if (StringUtils.isEmpty(sign)) {
            errorMessage = "请求参数[sign]不能为空.";
            return errorMessage;
        }

        // 验证签名数据
        boolean verifyFlag = XXPayUtil.verifyPaySign(params, key);
        if(!verifyFlag) {
            errorMessage = "验证签名失败.";
            return errorMessage;
        }
*/

        return null;
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

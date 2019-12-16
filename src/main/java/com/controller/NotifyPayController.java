package com.controller;

import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Api(tags="订单回调")
@RestController
@EnableAutoConfiguration
public class NotifyPayController {

    @RequestMapping("/notify/{channel}/notify_res.htm")
    public String payNotifyRes(HttpServletRequest request, @PathVariable("channel") String channel) throws Exception {

        return null;
    }

    /**
     * 支付渠道前台通知跳转
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/notify/{channel}/return_res.htm")
    public String payReturnRes(HttpServletRequest request, @PathVariable("channel") String channel) throws ServletException, IOException {

        return "notify/show";
    }
}

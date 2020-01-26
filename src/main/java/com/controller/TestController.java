package com.controller;

import com.system.Response;
import com.system.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="测试模块")
@RestController
@RequestMapping(value="/test")
@EnableAutoConfiguration
public class TestController {

    @ApiOperation(value="", notes="测试Swagger2")
    @GetMapping(value = "/pay/test")
    public String test() {
        return Response.get(ResponseCode.EXECUTE_SUCCESS).toString();
    }

    @ApiOperation(value="", notes="测试Swagger2")
    @GetMapping(value = "/pay/test1")
    public Response test1() {
        return Response.get(ResponseCode.EXECUTE_SUCCESS);
    }

}

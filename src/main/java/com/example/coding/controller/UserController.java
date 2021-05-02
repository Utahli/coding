package com.example.coding.controller;

import com.example.coding.entity.DemoDto;
import com.example.coding.entity.ResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: liqingtai
 * @Email: liqingtai@guazi.com
 * @DateTime: 2021/1/29 下午6:42
 */
@Api("用户操作接口")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    /**
     * @param input
     * @return
     */
    @ApiImplicitParam(name = "telephone", value = "电话号码", paramType = "query", required = true, dataType = "Integer")
    @ApiOperation(value = "post请求调用示例", notes = "invokePost说明", httpMethod = "POST")
    @PostMapping("/test")
    public ResponseModel invokePost(@ApiParam(name = "传入对象", value = "传入json格式", required = true) @RequestBody @Valid DemoDto input) {
        log.info("/testPost is called. input=" + input.toString());
        return new ResponseModel("0", "");
    }

}

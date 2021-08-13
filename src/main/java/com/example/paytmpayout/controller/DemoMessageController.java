package com.example.paytmpayout.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.paytmpayout.annotation.ControllerEndpoint;
import com.example.paytmpayout.module.SecnResponse;
import com.example.paytmpayout.utils.SecnResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author BINGAI
 * @since 2021-07-29
 */
@Api(tags = "测试Controller")
@Controller
@RequestMapping("/demo")
public class DemoMessageController {


    
    @ResponseBody
    @PostMapping("/message")
    @ApiOperation(value = "测试消息入库")
    @ControllerEndpoint(operation = "测试消息入库")
    public SecnResponse message(@RequestBody String req) {

        if (StringUtils.isEmpty(req)) {
            return SecnResponseUtil.ok("参数不能为空!");
        }


        return SecnResponseUtil.ok();

    }

}


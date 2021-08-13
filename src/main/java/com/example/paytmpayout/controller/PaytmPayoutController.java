package com.example.paytmpayout.controller;

import com.example.paytmpayout.controller.req.PaytmPayoutReq;

import com.example.paytmpayout.controller.req.WithdrawCheckReq;
import com.example.paytmpayout.module.PaytmPayoutResponse;
import com.example.paytmpayout.module.SecnResponse;
import com.example.paytmpayout.service.PaytmService;
import com.example.paytmpayout.toolkit.ExceptionUtils;
import com.example.paytmpayout.utils.SecnResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Api(tags = "支付转账相关前端控制器")
@Controller
@RequestMapping("/paytmPayoutController")
public class PaytmPayoutController {


    @Autowired
    private PaytmService paytmService;


    //private RedisTemplate<String, String> redisTemplate;

    @ResponseBody
    @PostMapping("/inner_withdraw")
    @ApiOperation("支付转账")
    public SecnResponse innerWithdraw(@RequestBody PaytmPayoutReq param) {

        //redisTemplate.opsForValue().set("paytm:order:" + otn, orderId);

        PaytmPayoutResponse o = (PaytmPayoutResponse) paytmService.bankTransfer(param);
        return SecnResponseUtil.ok(o);

    }

    @ResponseBody
    @PostMapping("/inner_withdrawcheck")
    @ApiOperation("转账转态")
    public SecnResponse innerWithdrawCheck(@RequestBody WithdrawCheckReq req){

        if(!(Objects.nonNull(req) && StringUtils.isNotEmpty(req.getOrderId()))){
            ExceptionUtils.throwException("请求参数不能为空！");
        }
        Object o = paytmService.statusCheck(req);
        return SecnResponse.ok(o);
    }
}

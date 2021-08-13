package com.example.paytmpayout.service.impl;

import com.example.paytmpayout.controller.req.PaytmPayoutReq;
import com.example.paytmpayout.controller.req.WithdrawCheckReq;
import com.example.paytmpayout.module.PaytmPayoutParam;
import com.example.paytmpayout.payoutimpl.PaytmPayoutStatusCheckProcessorImpl;
import com.example.paytmpayout.payoutimpl.PaytmPayoutVariateProcessorImpl;
import com.example.paytmpayout.service.PaytmService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaytmServiceImpl implements PaytmService {


    @Autowired
    private PaytmPayoutVariateProcessorImpl paytmPayoutVariateProcessor;

    @Autowired
    private PaytmPayoutStatusCheckProcessorImpl paytmPayoutStatusCheckProcessor;

    @Override
    public Object bankTransfer(PaytmPayoutReq param) {
        PaytmPayoutParam payoutParam = new PaytmPayoutParam();
        BeanUtils.copyProperties(param,payoutParam);
        return paytmPayoutVariateProcessor.process(payoutParam);
    }

    @Override
    public Object statusCheck(WithdrawCheckReq req) {
        PaytmPayoutParam param = new PaytmPayoutParam();
        param.setOrderId(req.getOrderId());
        return paytmPayoutStatusCheckProcessor.process(param);
    }

}

package com.example.paytmpayout.service;

import com.example.paytmpayout.controller.req.PaytmPayoutReq;
import com.example.paytmpayout.controller.req.WithdrawCheckReq;
import com.example.paytmpayout.module.PaytmPayoutParam;
import com.example.paytmpayout.module.PaytmPayoutResponse;

public interface PaytmService {

    Object bankTransfer(PaytmPayoutReq param);

    Object statusCheck(WithdrawCheckReq req);
}

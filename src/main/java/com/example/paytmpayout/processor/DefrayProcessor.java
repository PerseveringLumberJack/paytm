package com.example.paytmpayout.processor;

import com.example.paytmpayout.module.PaytmPayoutParam;

public interface DefrayProcessor {


    Object process(PaytmPayoutParam param);
}

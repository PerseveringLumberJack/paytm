package com.example.paytmpayout.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.paytmpayout.config.ConfigStore;
import com.paytm.pg.merchant.PaytmChecksum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class PaytmChecksumService {

    @Autowired
    private ConfigStore configStore;


    public String generateChecksum(String param) throws Exception {
        return PaytmChecksum.generateSignature(param, configStore.getPaytmPayoutMerchantKey());
    }


    public HttpEntity<String> producedEntity(String paytmPayoutParam) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-mid", configStore.getPaytmPayoutMerchantId());
        String checksum = generateChecksum(paytmPayoutParam);
        headers.set("x-checksum", checksum);
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>((paytmPayoutParam), headers);
    }

}

package com.example.paytmpayout.payoutimpl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.paytmpayout.config.ConfigStore;
import com.example.paytmpayout.dto.WithdrawCheckDto;
import com.example.paytmpayout.module.PaytmOrderStatusResponse;
import com.example.paytmpayout.module.PaytmPayoutParam;
import com.example.paytmpayout.module.PaytmPayoutResponse;
import com.example.paytmpayout.processor.AbstractDefrayProcessor;
import com.example.paytmpayout.service.impl.PaytmChecksumService;
import com.example.paytmpayout.template.RestTemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class PaytmPayoutStatusCheckProcessorImpl extends AbstractDefrayProcessor<HttpEntity<String>, PaytmOrderStatusResponse,Object> {

    @Autowired
    private ConfigStore configStore;

    @Autowired
    private PaytmChecksumService paytmChecksumService;

    @Autowired
    private RestTemplateRepository restTemplateRepository;

    @Override
    protected ResponseEntity<String> exchange(HttpEntity<String> o) {
        return restTemplateRepository.exchange(configStore.getPaytmPayoutApisStatusQuery(),o);
    }

    @Override
    protected PaytmOrderStatusResponse toResponseObject(ResponseEntity<String> entity) {

        if(Objects.isNull(entity))
            return null;
        String body = entity.getBody();
        if(StringUtils.isNotEmpty(body)){
            return JSONObject.parseObject(body, PaytmOrderStatusResponse.class);
        }
        return null;
    }

    @Override
    protected HttpEntity<String> toRequestObject(PaytmPayoutParam param) {
        try {
            String paytmPayoutParam = JSONObject.toJSONString(new WithdrawCheckDto(param.getOrderId()));
            return paytmChecksumService.producedEntity(paytmPayoutParam);
        } catch (Exception e) {
            log.info("[PaytmChecksum]:???????????????????????????:{}",e.getMessage());
        }
        return null;
    }
}

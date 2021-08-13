package com.example.paytmpayout.processor;

import com.example.paytmpayout.module.PaytmPayoutParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class AbstractDefrayProcessor<T,P,E> implements DefrayProcessor{

    protected abstract ResponseEntity exchange(T o);

    protected abstract P toResponseObject(ResponseEntity<String> entity);

    protected abstract T toRequestObject(PaytmPayoutParam param);

    @Override
    public Object process(PaytmPayoutParam param) {
        ResponseEntity<String> result = exchange(toRequestObject(param));
        P response = toResponseObject(result);
        return response;
    }
}

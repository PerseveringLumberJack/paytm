package com.example.paytmpayout.template.impl;

import com.example.paytmpayout.template.RestTemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
public class RestTemplateRepositoryImpl implements RestTemplateRepository<String> {

    //银行转账

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public ResponseEntity<String> exchange(String api,HttpEntity<String> o) {
        return restTemplate.exchange(api, HttpMethod.POST, o, String.class);
    }
}

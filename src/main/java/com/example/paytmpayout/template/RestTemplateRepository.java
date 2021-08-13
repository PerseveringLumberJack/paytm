package com.example.paytmpayout.template;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface RestTemplateRepository<T> {

    ResponseEntity<T> exchange(String api,HttpEntity<T> o);
}

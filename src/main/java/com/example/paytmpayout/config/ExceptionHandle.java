package com.example.paytmpayout.config;


import com.example.paytmpayout.module.SecnResponse;
import com.example.paytmpayout.toolkit.SecnException;
import com.example.paytmpayout.utils.SecnResponseUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler
    public SecnResponse handle(Exception exception){

        if(exception instanceof SecnException){
            return SecnResponseUtil.fail(exception.getMessage());
        }else {
            return SecnResponseUtil.fail("未知异常!");
        }
    }


}

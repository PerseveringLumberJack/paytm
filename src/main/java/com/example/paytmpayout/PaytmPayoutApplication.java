package com.example.paytmpayout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class PaytmPayoutApplication {

    public static void main(String[] args) throws UnknownHostException {

        ConfigurableApplicationContext context = SpringApplication.run(PaytmPayoutApplication.class, args);
        Environment environment = context.getBean(Environment.class);
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        log.info(" 访问地址: HTTP://{}:{}\t",hostAddress,environment.getProperty("server.port"));
    }

}

package com.example.paytmpayout.messageconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;
import java.math.BigInteger;

/**
 * 解决long精度丢失的
 */
public class LongClassMessageConverter implements InitializingBean {

    @Resource
    ObjectMapper objectMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        SimpleModule simpleModule = getSimpleModule();
        objectMapper.registerModule(simpleModule);
    }

    private SimpleModule getSimpleModule() {

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(BigInteger.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        // 暂时放弃对小long的转换，约定与前端交互数据时，大Long全部转换成字符串
//        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
        return simpleModule;
    }
}

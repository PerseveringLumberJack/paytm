package com.example.paytmpayout.convert;


import com.example.paytmpayout.entity.IOperationalLogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OperationalLogEntityTransfer {


    OperationalLogEntityTransfer instance = Mappers.getMapper(OperationalLogEntityTransfer.class);



    @Mappings({
            @Mapping(target = "operationalMethod",source = "operationalMethod"),
            @Mapping(target = "operationalParams", source = "params"),
            @Mapping(target = "operationalIp",source = "ip"),
            @Mapping(target = "operationalContent",source = "operation"),
            @Mapping(target = "registrationToken",source = "registrationToken"),
            @Mapping(target = "timeConsuming",source = "timeConsuming"),
            @Mapping(target = "responseParameters",expression = "java(com.alibaba.fastjson.JSON.toJSONString(o))"),
            @Mapping(target = "createTime",expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "createTimestamp",expression = "java(java.util.Calendar.getInstance().getTimeInMillis())")
    })
    IOperationalLogEntity convertOperationalLogEntity(String operationalMethod, String params, String ip, String operation, String registrationToken, Long timeConsuming, Object o);
}

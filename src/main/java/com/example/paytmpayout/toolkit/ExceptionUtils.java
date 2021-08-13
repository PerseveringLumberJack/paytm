package com.example.paytmpayout.toolkit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Objects;

public final class ExceptionUtils {


    public static final void throwIfTrue(Boolean condition,String errMsg){
        if(condition)
            throw new SecnException(errMsg);
    }

    public static final void throwIfFalse(Boolean condition,String errMsg){
        if(!condition)
            throw new SecnException(errMsg);
    }

    public static final void throwIfNull(Object object,String errMsg){
        if(Objects.isNull(object))
            throw new SecnException(errMsg);
    }

    public static final void throwIfNotNull(Object object,String errMsg){
        if(Objects.nonNull(object))
            throw new SecnException(errMsg);
    }

    public static final void throwIfEmpty(Collection collection, String errMsg){
        if(CollectionUtils.isEmpty(collection))
            throw new SecnException(errMsg);
    }

    public static final void throwIfEmpty(String str, String errMsg){
        if(StringUtils.isEmpty(str))
            throw new SecnException(errMsg);
    }

    public static final void throwException(String errMsg){
        throw new SecnException(errMsg);
    }

    public static final void throwException(String errMsg,int code){
        throw new SecnException(errMsg,code);
    }

    private static final String checkMsgLength(String msg){
        if(StringUtils.isNotEmpty(msg)){
            return msg.length()>30?msg.substring(0,30):msg;
        }
        return msg;
    }
    public ExceptionUtils() {}
}

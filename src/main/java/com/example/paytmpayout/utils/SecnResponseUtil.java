package com.example.paytmpayout.utils;


import com.example.paytmpayout.module.SecnResponse;

public class SecnResponseUtil {

    public SecnResponseUtil() {}

    public static SecnResponse ok() {
        return SecnResponse.ok();
    }

    public static SecnResponse ok(Object data) {
        return SecnResponse.ok(data);
    }

    public static SecnResponse fail(String msg) {
        return SecnResponse.fail(msg);
    }
}

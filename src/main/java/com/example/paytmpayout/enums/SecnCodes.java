package com.example.paytmpayout.enums;

public enum SecnCodes {

    SUCCESS(0,"SUCCESS"),

    FAIL(400,"FAIL"),

    UNAUTHORIZED(401,"UNAUTHORIZED"),

    NOT_FOUND(404,"NOT_FOUND"),

    INTERNAL_SERVER_ERROR(500,"INTERNAL_SERVER_ERROR");

    private final int code;

    private String message;


    SecnCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

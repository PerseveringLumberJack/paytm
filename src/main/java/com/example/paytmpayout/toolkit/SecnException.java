package com.example.paytmpayout.toolkit;


import com.example.paytmpayout.enums.SecnCodes;

public class SecnException extends RuntimeException {

    protected int code;

    public SecnException() {
        super(SecnCodes.INTERNAL_SERVER_ERROR.getMessage());
        this.code = SecnCodes.INTERNAL_SERVER_ERROR.getCode();
    }

    public SecnException(String message) {
        super(message);
        this.code = SecnCodes.INTERNAL_SERVER_ERROR.getCode();
    }

    public SecnException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}

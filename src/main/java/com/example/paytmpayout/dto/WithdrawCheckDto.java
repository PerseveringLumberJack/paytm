package com.example.paytmpayout.dto;


import lombok.Data;

import java.io.Serializable;


@Data
public class WithdrawCheckDto implements Serializable {

    private static final long serialVersionUID = 1535698714285713726L;

    private String orderId;

    public WithdrawCheckDto(String orderId) {
        this.orderId = orderId;
    }

    public WithdrawCheckDto() {
    }
}

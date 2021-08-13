package com.example.paytmpayout.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "转账转态请求参数")
public class WithdrawCheckReq implements Serializable {

    private static final long serialVersionUID = 1535698714285713726L;

    @ApiModelProperty(value = "订单ID",example = "【ORDERID_98765】 如果为查询订单状态只需传订单ID即可")
    private String orderId;



}

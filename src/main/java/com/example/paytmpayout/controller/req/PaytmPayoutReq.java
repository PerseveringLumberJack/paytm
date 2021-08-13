package com.example.paytmpayout.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "支付转账请求参数")
public class PaytmPayoutReq implements Serializable {

    private static final long serialVersionUID = 1535098714285713726L;

    @ApiModelProperty(value = "子钱包",example = "28054249-XXXX-XXXX-af8f-fa163e429e83")
    private String subwalletGuid;

    @ApiModelProperty(value = "订单ID",example = "【ORDERID_98765】 如果为查询订单状态只需传订单ID即可")
    private String orderId;

    @ApiModelProperty(value = "收款账户",example = "918008484891")
    private String beneficiaryAccount;

    @ApiModelProperty(value = "收款IFSC",example = "PYTM0123456")
    private String beneficiaryIFSC;

    @ApiModelProperty(value = "数量",example = "1.00")
    private String amount;

    @ApiModelProperty(value = "目的",example = "SALARY_DISBURSEMENT")
    private String purpose;

    @ApiModelProperty(value = "时间",example = "2020-06-01")
    private String date;

}

package com.example.paytmpayout.module;

import lombok.Data;

/**
 * mid
 * string(50)
 * Paytm provides MID as a unique identifier to each merchant. For your staging MID, click here. You get the production MID post the account activation.
 *
 * Example: INTEGR7769XXXXXX9383
 *
 * orderId
 * string(50)
 * The Unique reference ID of the Order. It is alphanumeric and special characters allowed are “@” “-” “_” “.”.
 * Example: OREDRID_98765
 *
 * Unique reference id provided by the merchant for this disbursal request.
 *
 * paytmOrderId
 * string(50)
 * Unique ID generated at paytm end corresponding to each transaction.
 *
 * amount
 * string
 * Amount in INR requested by the merchant for disbursal.
 *
 * commissionAmount
 * string
 * Commission amount in INR payable by the merchant. This will contain digits up to two decimal points.
 *
 * tax
 * string
 * Tax amount in INR payable by the merchant.This will contain digits up to two decimal points.
 *
 * rrn
 * string(10)
 * Unique reference number created by a bank against each transaction.It is null for wallet transfers.
 */
@Data
public class PaytmOrderStatusResult {

    private String mid;

    private String orderId;

    private String paytmOrderId;

    private String amount;

    private String commissionAmount;

    private String tax;

    private String rrn;
}

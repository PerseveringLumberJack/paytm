package com.example.paytmpayout.module;

import lombok.Data;

/**
 * Response Attributes
 * Content Type : JSON
 * Body
 * ATTRIBUTE	DESCRIPTION
 * statusCode
 * string
 * Failure reason code where status is FAILURE. A detailed list of statusCode is mentioned at the bottom of this page.
 *
 * status
 * string
 * Disbursal request status. This attribute should be used to fetch the final status of the order. It can be FAILURE, ACCEPTED, SUCCESS, CANCELLED, PENDING, and QUEUED.
 *
 * statusMessage
 * string
 * Description of each statusCode.
 *
 * result
 * object
 * Result details for the transfer APIs.
 */
@Data
public class PaytmOrderStatusResponse {

    private String statusCode;

    private String status;

    private String statusMessage;

    private PaytmOrderStatusResult result;
}

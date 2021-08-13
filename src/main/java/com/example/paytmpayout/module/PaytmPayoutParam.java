package com.example.paytmpayout.module;

import lombok.Data;

import java.io.Serializable;

/**
 * Request Attributes
 * API Content Type: JSON
 * ATTRIBUTE	DESCRIPTION
 * orderId
 * <p>
 * string(50)
 * mandatory
 * <p>
 * It should be an alphanumeric, merchant’s unique reference ID for a disburse transaction passed in the request. This is Order ID for which the disburse order status needs to be fetched. Length should be 50 characters or less.
 * subwalletGuid
 * <p>
 * string
 * mandatory
 * <p>
 * Merchants sub wallet guid. Sub Wallet GUID is available on dashboard as "GUID".
 * amount
 * <p>
 * string
 * mandatory
 * <p>
 * Amount in INR payable by the merchant and it should contain digits up to two decimal points. The only special character allowed is (“.”). Amount limit from 1 to 2 Cr.
 * purpose
 * <p>
 * string(50)
 * mandatory
 * <p>
 * Pass any one from the below options:
 * SALARY_DISBURSEMENT
 * REIMBURSEMENT
 * BONUS
 * INCENTIVE
 * OTHERS
 * date
 * <p>
 * string(10)
 * conditionally mandatory
 * <p>
 * Pass the date for which the merchant wants to disburse the amount. Required for SALARY_DISBURSEMENT and REIMBURSEMENT. Date format <YYYY-MM-DD>.
 * <p>
 * Note: Mandatory if the "purpose" is Salary or Reimbursement
 * <p>
 * callbackUrl
 * <p>
 * string(255)
 * optional
 * <p>
 * URL where we will post disbursal status. The merchant needs to whitelist this URL with Paytm.
 * comments
 * <p>
 * string(50)
 * optional
 * <p>
 * Disbursal comments whose length should be 50 characters or below
 * transactionType
 * <p>
 * string
 * optional
 * <p>
 * Transaction Type is only applicable if transferMode is UPI. It can have the following Values:
 * <p>
 * NON_CASHBACK - For all type of transactions except if you sending cashback to the end users
 * CASHBACK - Send this value when you are sending cashback to end users
 * By Default, NON_CASHBACK will be selected.
 * <p>
 * transferMode
 * <p>
 * string(25)
 * mandatory
 * <p>
 * Merchant can use this field to specify the disbursal mode. Pass any one from below:
 * IMPS
 * NEFT
 * UPI
 * RTGS
 * beneficiaryName
 * <p>
 * string
 * conditional
 * <p>
 * Beneficiary name is optional if transferMode is IMPS/UPI and mandatory if transferMode is NEFT and RTGS.
 * beneficiaryAccount
 * <p>
 * string(19)
 * mandatory
 * <p>
 * Bank account number of the beneficiary to which the disbursal should be made.
 * beneficiaryIFSC
 * <p>
 * string(11)
 * mandatory
 * <p>
 * IFSC code of the beneficiary account holding bank branch.
 * beneficiaryVPA
 * <p>
 * string
 * mandatory
 * <p>
 * VPA of the beneficiary to which the disbursal should be made
 * beneficiaryPhoneNo
 * <p>
 * string
 * mandatory
 * <p>
 * Phone No. of the beneficiary to which the disbursal should be made
 * beneficiaryContactRefId
 * <p>
 * string
 * mandatory
 * <p>
 * Unique identifier linked to the contact. Based on the Transfer mode, funds will be transferred to the default bank Account/ VPA for the Contact.
 * Note:
 * <p>
 * For Transfer through IMPS, NEFT, RTGS Transfer mode  you have to send either beneficiaryAccount & beneficiaryIFSC OR beneficiaryMID OR beneficiaryContactRefId in disbursal request.
 * For UPI Transfer, You have to choose anyone from beneficiaryVPA/ beneficiaryPhoneNo/ beneficiaryCustId/ beneficiaryContactRefId in disbursal request.
 * For Bank Reversal, please add Reversal Status Webhook on dashboard under the Developer Settings. Please click here for detailled documentation on Reversals. Pass anyone from beneficiaryVPA/ beneficiaryPhoneNo/ beneficiaryCustId/
 * beneficiaryAccount & beneficiaryIFSC/beneficiaryContactRefId in disbursal request.
 */
@Data
public class PaytmPayoutParam implements Serializable {

    private String subwalletGuid;

    private String orderId;

    private String beneficiaryAccount;

    private String beneficiaryIFSC;

    private String amount;

    private String purpose;

    private String date;

}

package com.example.paytmpayout.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 配置常量
 */
@Component
@Data
public class ConfigStore {

	@Value("${paytm.payout.apis.bank-transfer}")
	private String paytmPayoutApisBankTransfer;//银行转账

	@Value("${paytm.payout.merchant-id}")
	private String paytmPayoutMerchantId;

	@Value("${paytm.payout.merchant-key}")
	private String paytmPayoutMerchantKey;

	@Value("${paytm.payout.guid}")
	private String paytmPayoutGuid;

	@Value("${paytm.payout.apis.status-query}")
	private String paytmPayoutApisStatusQuery;

	@Value("${paytm.payout.callback}")
	private String paytmPayoutCallback;

}




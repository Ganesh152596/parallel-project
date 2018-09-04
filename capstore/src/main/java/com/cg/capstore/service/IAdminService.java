package com.cg.capstore.service;

import java.util.List;

import com.cg.capstore.bean.MerchantBean;
import com.cg.capstore.bean.PaymentDetailsBean;
import com.cg.capstore.exception.MerchantException;

public interface IAdminService {

	public MerchantBean addMerchant(MerchantBean merchant) throws MerchantException;
	
	public void deleteMerchant(String Id) throws MerchantException;
	
	public MerchantBean addThirdPartyMerchant(MerchantBean merchant) throws MerchantException;

	
	public double updateRevenue(String payment);
	
}

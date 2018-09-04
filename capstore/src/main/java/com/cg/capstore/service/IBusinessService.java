package com.cg.capstore.service;

import java.sql.Date;
import java.util.List;

import com.cg.capstore.bean.MerchantBean;
import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.bean.PaymentDetailsBean;
import com.cg.capstore.exception.BusinessException;

public interface IBusinessService {
	
	public List<PaymentDetailsBean> transactionAnalysis(Date start, Date end);
	
	public MerchantBean category(String emailId) throws BusinessException;
	
	public OrderBean getDetails(String orderId) throws BusinessException;
	
	
}

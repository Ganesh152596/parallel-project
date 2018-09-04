package com.cg.capstore.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.MerchantBean;
import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.bean.PaymentDetailsBean;
import com.cg.capstore.exception.BusinessException;
import com.cg.capstore.repo.BusinessRepository;

@Service
public class BusinessServiceImpl implements IBusinessService{
	@Autowired
	BusinessRepository repo;
	
	@Override
	public List<PaymentDetailsBean> transactionAnalysis(Date start, Date end){
		
		return repo.transactionAnalysis(start, end);
	}
	@Override
	public MerchantBean category(String emailId) throws BusinessException{
		
		return repo.getId(emailId);
	}
	@Override
	public OrderBean getDetails(String orderId) throws BusinessException {
		
		return repo.getDetails(orderId);
	}
	
}





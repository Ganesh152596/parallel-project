package com.cg.capstore.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.MerchantBean;
import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.bean.PaymentDetailsBean;
import com.cg.capstore.exception.BusinessException;
import com.cg.capstore.service.IBusinessService;

@RestController
public class BusinessController {
	@Autowired
	IBusinessService service;


	@RequestMapping(value="/generateanalysis",method=RequestMethod.GET)
	public List<PaymentDetailsBean> transactionAnalysis(Date start, Date end){

		return service.transactionAnalysis(start, end);
	}

	@RequestMapping(value="/merchant",method=RequestMethod.GET)
	public MerchantBean category(String emailId) throws BusinessException{
		return service.category(emailId);

	}
	@RequestMapping(value="/report",method=RequestMethod.GET)
	public OrderBean getDetails(String orderId) throws BusinessException {
		return service.getDetails(orderId);
	}

}

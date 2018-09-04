package com.cg.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.MerchantBean;
import com.cg.capstore.exception.MerchantException;
import com.cg.capstore.service.FeedbackCommon;
import com.cg.capstore.service.IAdminService;
import com.cg.capstore.service.IFeedbackCommon;


@RestController
public class CapstoreController {
	@Autowired
	private IAdminService service;


	@Autowired
	private IFeedbackCommon feedbackService;

	@RequestMapping(value="/revenue1",method=RequestMethod.GET)
	public String updateRevenue (String payment) {
		System.err.println("IN BACK REST CALLING");
		//System.err.println(payment);
		double rev = service.updateRevenue(payment);
		System.err.println("OUT OF BACK JSP CALLING");
		System.err.println("Capstore revenur is "+rev);
		return "Capstore revenur is "+rev;
	}
	@RequestMapping(value="/addMerchant",method=RequestMethod.POST)
	public String merchantAddition(@RequestBody MerchantBean merchant) throws MerchantException
	{
		System.err.println("In Back Controller..."+merchant);
		try {
			service.addMerchant(merchant);
		} catch (MerchantException e) {
			// TODO Auto-generated catch block
			throw new MerchantException(e.getMessage());
		}
		System.err.println("Out of Back COntroller...");
		return "Merchant with Id "+merchant.getEmailId()+" Added";
	}
	
	
	
	
	
	@RequestMapping(value="/DeleteMerchant",method=RequestMethod.DELETE)
	public String merchantDelete( String emailId) throws MerchantException
	{
		try {
			service.deleteMerchant(emailId);
		} catch (MerchantException e) {
			// TODO Auto-generated catch block
			throw new MerchantException(e.getMessage());
		}
		return "Merchant with Id "+emailId+" Deleted";
	}


	
	@RequestMapping(value="/AddThirdPartyMerchant",method=RequestMethod.POST)
	public void thirdPartyMerchantAddition(@RequestBody MerchantBean merchant) throws MerchantException
	{
		try {
			service.addThirdPartyMerchant(merchant);
		} catch (MerchantException e) {
			// TODO Auto-generated catch block
			throw new MerchantException(e.getMessage());
		}
	}



	/*@RequestMapping(value="/UpdateMerchant",method=RequestMethod.POST)
	public void merchantUpdation(@RequestBody MerchantBean merchant)
	{
		service.UpdateMerchant(merchant);
	}*/

	public String feedbackCommon(@RequestBody FeedbackCommon feedback)
	{
		return feedbackService.feedbackCommon(feedback);
	}

}

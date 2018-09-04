package com.cg.capstore.service;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.bean.MerchantBean;

public interface IEmailService {
	public String RegiteredNewUser(String name);

	public MerchantBean sendInvitationToMerchant(String email);

	public CustomerBean sentInvitationToCustomer(String email);

	public String sendSchemeToMerchant(String name);

	public String sendSchemeToCustomer(String name);

	public String sendPromoToMerchant(String name);

	public String sendPromoToCustomer(String name);


}

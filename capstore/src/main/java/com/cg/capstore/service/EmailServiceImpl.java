package com.cg.capstore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.bean.MerchantBean;
import com.cg.capstore.repo.EmailRepo;

@Service
public class EmailServiceImpl implements IEmailService {
	@Autowired
	private EmailRepo emailRepo;

	@Override
	public String RegiteredNewUser(String name) {
		// TODO Auto-generated method stub
		return emailRepo.findCustomerEmail(name);
	}

	@Override
	public CustomerBean sentInvitationToCustomer(String email) {
		// TODO Auto-generated method stub
		return emailRepo.findCustomer(email);
	}

	@Override
	public MerchantBean sendInvitationToMerchant(String email) {
		// TODO Auto-generated method stub
		return emailRepo.findMechant(email);
	}

	@Override
	public String sendSchemeToMerchant(String name) {
		// TODO Auto-generated method stub
		return emailRepo.findMerchantEmail(name);
	}

	@Override
	public String sendSchemeToCustomer(String name) {
		// TODO Auto-generated method stub
		return emailRepo.findCustomerEmail(name);
	}

	@Override
	public String sendPromoToMerchant(String name) {
		// TODO Auto-generated method stub
		return emailRepo.findMerchantEmail(name);
	}

	@Override
	public String sendPromoToCustomer(String name) {
		// TODO Auto-generated method stub
		return emailRepo.findCustomerEmail(name);
	}

}

package com.cg.capstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.bean.MerchantBean;
import com.cg.capstore.bean.PaymentDetailsBean;
import com.cg.capstore.exception.MerchantException;
import com.cg.capstore.repo.ICapStoreRepo;
import com.cg.capstore.repo.IPaymentDetailsRepo;

@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private ICapStoreRepo repo;
	@Autowired
	private IPaymentDetailsRepo paymentRepo;
	
	
	@Transactional
	@Override
	public double updateRevenue(String payment) {
		
		PaymentDetailsBean payment1= paymentRepo.getOne(payment);
		payment1.setTransactionId(payment);
		
		double revenue=payment1.getCapStoreRevenueAmount();
		double amt = payment1.getPaymentAmount().getMinBillingAmount();
		revenue=revenue+amt;
				
		payment1.setCapStoreRevenueAmount(revenue);
		paymentRepo.save(payment1);
		
		return revenue;
		
	}


	@Override
	public MerchantBean addMerchant(MerchantBean merchant) throws MerchantException{
		return	repo.save(merchant);
		 	
	}
	@Override
	public void deleteMerchant(String id) throws MerchantException{
		
		
		repo.deleteById(id);
		
	}

	@Override
	public MerchantBean addThirdPartyMerchant(MerchantBean merchant) throws MerchantException{
		return	repo.save(merchant);
	}

	

	
	
	
	

}

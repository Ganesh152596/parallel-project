package com.cg.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capstore.bean.PaymentDetailsBean;

public interface IPaymentDetailsRepo extends JpaRepository<PaymentDetailsBean,String> {

	@Query("select e.minBillingAmount from OrderBean e where e.orderId=(:id)")
	public double getAmount(@Param(value="id") String id);
	
	@Query("select e.transactionDate,e.paymentAmount,e.transactionId from PaymentDetailsBean e where e.transactionId=(:id)")
	public PaymentDetailsBean findtransactionBytransactionId(@Param(value="id") String id);

}

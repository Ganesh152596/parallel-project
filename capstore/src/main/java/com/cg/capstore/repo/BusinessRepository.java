package com.cg.capstore.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.capstore.bean.MerchantBean;
import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.bean.PaymentDetailsBean;
import com.cg.capstore.bean.ProductBean;

@Repository
public interface BusinessRepository extends JpaRepository<ProductBean, String>{
	
	
	@Query("select a from PaymentDetailsBean a where a.transactionDate BETWEEN (:start) AND (:end)")
	List<PaymentDetailsBean> transactionAnalysis(@Param(value="start") Date start,@Param(value="end") Date end);
	
	@Query(value="select a from MerchantBean a where a.emailId=(:emailId) ")
	MerchantBean getId(@Param(value="emailId")String emailId);
	
	@Query(value="select a from OrderBean a where a.orderId=(:orderId) ")
	OrderBean getDetails(@Param(value="orderId")String orderId);
	
	
	
	
}

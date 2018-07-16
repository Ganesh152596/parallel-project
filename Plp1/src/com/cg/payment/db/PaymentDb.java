package com.cg.payment.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.payment.bean.Payment;



public class PaymentDb {
	private static HashMap<String,Payment> paymentDb=new HashMap<String,Payment>();
	public static HashMap<String, Payment> getpaymentMap() {
	return paymentDb;
}
	Payment obj=new Payment();
	static{
		
		paymentDb.put("9999999999",new Payment("9999999999","Rakesh","rakesh@gmail.com",3000.0,LocalDateTime.now()));
		paymentDb.put("8888888888",new Payment("8888888888","Santhosh","santhosh@gmail.com",1000.0,LocalDateTime.now()));
		paymentDb.put("7777777777",new Payment("7777777777","Ganesh","ganesh@gmail.com",2000.0,LocalDateTime.now()));
		paymentDb.put("6666666666",new Payment("6666666666","Shyam","shyam@gmail.com",2500.0,LocalDateTime.now()));
		}
	}

package com.cg.payment.dao;

import java.util.HashMap;

import com.cg.payment.bean.Payment;
import com.cg.payment.db.PaymentDb;
import com.cg.payment.exception.PaymentException;

public class PaymentDao implements IPaymentDao {
	private static HashMap<String, Payment> paymentMap = PaymentDb.getpaymentMap();

	@Override
	public String createAccount(Payment account) throws PaymentException {
		paymentMap.put(account.getMobileNo(), account);
		return account.getMobileNo();
	}

	@Override
	public double viewBalance(String mobileNo) throws PaymentException {
		Payment account = paymentMap.get(mobileNo);
		if (account == null) {
		throw new PaymentException("The mobile number does not exist");
		}
		return account.getBalance();
	}

	@Override
	public Payment deposit(String mobileNo) throws PaymentException {
		Payment account = paymentMap.get(mobileNo);
		if (account == null) {
		throw new PaymentException("The mobile number does not exist");
		}
		return account;
	}

	@Override
	public Payment withdraw(String mobileNo) throws PaymentException {
		Payment account = paymentMap.get(mobileNo);
		if (account == null) {
		throw new PaymentException("The mobile number does not exist");
		}
		return account;
	}

	@Override
	public Payment printDetails(String mobileNo) throws PaymentException {
		Payment account = paymentMap.get(mobileNo);
		if (account == null) {
		throw new PaymentException("The mobile number does not exist");
		}
		return account;
	}

}

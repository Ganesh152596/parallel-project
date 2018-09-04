package com.cg.capstore.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class PaymentDetailsBean {

	@Id
	@Column(name="transaction_id")
	private String transactionId;
	
	@Column(name="transaction_date")
	private Date transactionDate;
	
	@OneToOne
	@JoinColumn(name="payment_amount")
	private OrderBean paymentAmount;
	
	
	@Column(name="revenue")
	private Double capStoreRevenueAmount;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public OrderBean getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(OrderBean paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Double getCapStoreRevenueAmount() {
		return capStoreRevenueAmount;
	}

	public void setCapStoreRevenueAmount(Double capStoreRevenueAmount) {
		this.capStoreRevenueAmount = capStoreRevenueAmount;
	}

	public PaymentDetailsBean(String transactionId, Date transactionDate, OrderBean paymentAmount,
			Double capStoreRevenueAmount) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.paymentAmount = paymentAmount;
		this.capStoreRevenueAmount = capStoreRevenueAmount;
	}
	
	public PaymentDetailsBean() {
		super();
	}

	@Override
	public String toString() {
		return "PaymentDetailsBean [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", paymentAmount=" + paymentAmount + ", capStoreRevenueAmount=" + capStoreRevenueAmount + "]";
	}
	
	
	
}

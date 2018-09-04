package com.cg.capstore.service;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.bean.OrderBean;
import com.cg.capstore.bean.PaymentDetailsBean;
import com.cg.capstore.bean.ProductBean;
import com.cg.capstore.repo.IOrderDetailsRepo;
import com.cg.capstore.repo.IPaymentDetailsRepo;
import com.cg.capstore.repo.IProductRepo;
import com.cg.capstore.repo.ICustomerRepo;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
	private ICustomerRepo custRepo;
    
    @Autowired
    private IProductRepo productRepo;
    
    @Autowired
    private IPaymentDetailsRepo paymentRepo;
    
    @Autowired
    private IOrderDetailsRepo orderRepo;
    
    
	@Override
	public String generateInvoice(String customerId)
	
	{
		
		String res = "";
				
		CustomerBean bean = custRepo.getOne(customerId);
		List<ProductBean> cartProd = bean.getCart();
		
		System.err.println(cartProd);
		
		for (ProductBean productBean : cartProd) {
			res = "<ul><li>Product Name: "+productBean.getProductName() + "</li>"
					+ "<br/><li> Product Price: "+productBean.getPrice()+"</li></ul>";
		}
		
		return "Hello "+customerId+"<br/> Your Product(s) are<br/>"+res;
		
	}
		
		
}

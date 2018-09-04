package com.cg.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.service.IInvoiceService;
@RestController
public class InvoiceController {
	@Autowired
	private IInvoiceService invoiceService;

	@RequestMapping(value="/generateInvoice",method=RequestMethod.POST)
	public String generateInvoice(@RequestBody String customerId)
	{
		return invoiceService.generateInvoice(customerId);
	}

}

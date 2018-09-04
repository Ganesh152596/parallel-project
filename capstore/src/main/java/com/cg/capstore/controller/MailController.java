package com.cg.capstore.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.bean.MerchantBean;
import com.cg.capstore.exception.MerchantException;
import com.cg.capstore.service.IEmailService;


@RestController
public class MailController {
	@Autowired
	private IEmailService EmailServiceImpl;
	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping(value = "/")
	public String check() {
		return "hello BACK RUNNING";
	}

	// register mail
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public String sendRegisteredMail(@RequestBody String name) throws MessagingException {
		System.err.println("In Back Controller--- Name:" + name);
		String customerEmail = EmailServiceImpl.RegiteredNewUser(name);

		sendRegisteredNewUser(name);
		System.err.println("Out Back Controller--- Name:" + customerEmail);
		if (customerEmail != null) {
			return "Scheme details have been sent to " + customerEmail;
		} else {
			return "customer does not exist";
		}
	}

	private void sendRegisteredNewUser(String name) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(EmailServiceImpl.RegiteredNewUser(name));
		helper.setText("you are registered successfully");
		helper.setSubject("Registered Successfully");
		javaMailSender.send(message);
	}

	// invitation to customer
	@RequestMapping(value = "/sendInvitationToCustomer", method = RequestMethod.POST)
	public String inviteCustomer(@RequestBody String email) throws MessagingException {
		System.err.println("IN BACK CONTROLLER...");
		System.err.println("email of customer:" + email);
		CustomerBean customeBean = EmailServiceImpl.sentInvitationToCustomer(email);
		String name = customeBean.getCustomerName();
		System.err.println("Back--- Name:" + name);
		sendInvitationToCustomer(email);
		if (customeBean.getEmail() != null) {
			return name + ",invitation has been sent to" + email;
		} else {
			return "customer does not exist";
		}
	}

	private void sendInvitationToCustomer(String email) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(email);
		helper.setText("Check out the products in capstore");
		helper.setSubject("Invitaiton From CapStore");
		javaMailSender.send(message);
	}

	// invitation to merchant
	@RequestMapping(value = "/sendInvitationToMerchant", method = RequestMethod.POST)
	public String inviteMerchant(@RequestBody String email) throws MessagingException {
		System.err.println("IN BACK CONTROLLER...");
		System.err.println("email of customer:" + email);
		MerchantBean merchantBean = EmailServiceImpl.sendInvitationToMerchant(email);
		String name = merchantBean.getMerchantName();
		System.err.println("Back--- Name:" + name);
		sendNewInvitationToMerchant(email);
		if (merchantBean.getEmailId() != null) {
			return name + ",invitation has been sent to" + email;
		} else {
			return "Merchant does not exist";
		}

	}

	private void sendNewInvitationToMerchant(String email) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(email);
		helper.setText("Check out the products in capstore");
		helper.setSubject("Invitaiton From CapStore");
		javaMailSender.send(message);
	}
	// scheme to customer

	@RequestMapping(value = "/sendSchemeToCustomer", method = RequestMethod.POST)
	public String sendSchemeToCustomer(@RequestBody String name) throws MessagingException {
		System.err.println("customer scheme bqack");
		System.err.println("In Back Controller--- Name:" + name);
		String customerEmail = EmailServiceImpl.sendSchemeToCustomer(name);
		System.err.println("Out Back Controller--- Name:" + customerEmail);
		sendNewSchemeToCustomer(name);
		if (customerEmail != null) {
			return "Scheme details have been sent to " + customerEmail;
		} else {
			return "customer does not exist";
		}
	}

	private void sendNewSchemeToCustomer(String name) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(EmailServiceImpl.sendSchemeToCustomer(name));
		helper.setText("Check out the new scheme in capstore");
		helper.setSubject("New Scheme in CapStore");
		javaMailSender.send(message);
	}
	// scheme to merchant

	@RequestMapping(value = "/sendSchemeToMerchant", method = RequestMethod.POST)
	public String sendSchemeToMerchant(@RequestBody String name) throws MessagingException {
		System.out.println("merchant");
		System.err.println("In Back Controller--- Name:" + name);
		String merchantEmail = EmailServiceImpl.sendSchemeToMerchant(name);
		sendNewSchemeToMerchant(name);
		if (merchantEmail != null) {
			return "Scheme details have been sent to " + merchantEmail;
		} else {
			return "merchant does not exist";
		}
	}

	private void sendNewSchemeToMerchant(String name) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(EmailServiceImpl.sendSchemeToMerchant(name));
		helper.setText("Check out the new scheme in capstore");
		helper.setSubject("New Scheme in CapStore");
		javaMailSender.send(message);
	}

	// promo to customer
	@RequestMapping(value = "/sendPromoToCustomer", method = RequestMethod.POST)
	public String sendPromoToCustomer(@RequestBody String name) throws MessagingException {
		System.err.println("customer scheme back");
		System.err.println("In Back Controller--- Name:" + name);
		String customerEmail = EmailServiceImpl.sendPromoToCustomer(name);
		System.err.println("Out Back Controller--- Name:" + customerEmail);
		sendNewPromoToCustomer(name);
		if (customerEmail != null) {
			return "Promo details have been sent to " + customerEmail;
		} else {
			return "customer does not exist";
		}
	}

	private void sendNewPromoToCustomer(String name) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(EmailServiceImpl.sendPromoToCustomer(name));
		helper.setText("Check out the new promo in capstore");
		helper.setSubject("New promo in CapStore");
		javaMailSender.send(message);
	}

	// promo to merchant

	@RequestMapping(value = "/sendPromoToMerchant", method = RequestMethod.POST)
	public String sendPromoToMerchant(@RequestBody String name) throws MessagingException {
		System.err.println("merchant scheme back");
		System.err.println("In Back Controller--- Name:" + name);
		String merchantEmail = EmailServiceImpl.sendPromoToMerchant(name);
		sendNewPromoToMerchant(name);
		System.err.println("Out Back Controller--- Name:" + merchantEmail);
		if (merchantEmail != null) {

			return "promo details have been sent to " + merchantEmail;
		} else {
			return "merchant does not exist";
		}
	}

	private void sendNewPromoToMerchant(String name) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(EmailServiceImpl.sendPromoToMerchant(name));
		helper.setText("Check out the new promo in capstore");
		helper.setSubject("New promo in CapStore");
		javaMailSender.send(message);
	}
	

	@RequestMapping(value="/sendInvitationToExistingMerchant", method=RequestMethod.POST)
	public String inviteExistingMerchant(@RequestBody String Email) throws MessagingException {
		System.err.println("IN BACK CONTROLLER...");
		System.err.println("email of customer:"+Email);
		MerchantBean merchantBean;
		merchantBean = EmailServiceImpl.sendInvitationToMerchant(Email);
		sendExistingInvitationToMerchant(Email);
		//String name=merchantBean.getMerchantName();
		//System.err.println("Back--- Name:"+name);
		return "Invitation has been sent successfully to "+Email;
	
	}


	private void sendExistingInvitationToMerchant(String email) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(email);
		helper.setText("Check out the products in capstore");
		helper.setSubject("Invitaiton From CapStore");
		javaMailSender.send(message);
	}
}

package com.cg.capstore.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.service.IInviteFriendService;

@RestController
public class InviteFriendController {
	
	@Autowired
	private IInviteFriendService inviteFriendService;
	
	@Autowired
	private JavaMailSender sender;
		
	public String inviteFriend(String name) throws MessagingException {
		String customerEmail = inviteFriendService.inviteFriend(name);
		sendInvitationToFriend(customerEmail);
		return "Success, Sending invitation";
	}
	
	
	private void sendInvitationToFriend(String customerEmail) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		//helper.setFrom(customerEmail);
		helper.setTo("deeprajadhikary333@gmail.com");
		helper.setText("Test Message...");
		helper.setSubject("Inviting You to Buy Products from this website");
		
		sender.send(message);
	}
	
}

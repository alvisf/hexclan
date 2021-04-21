package com.service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.model.SmsPojo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
	public class SmsService {

	    
	    private final String ACCOUNT_SID ="ACdab20ec010881c0f6f2b21548bf03bf9";

	    private final String AUTH_TOKEN = "cfff8e60cab3ed678a164c0d443d1f71";

	    private final String FROM_NUMBER = "+18323766309";

	    public void send(SmsPojo sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}
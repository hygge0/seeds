package com.test;

import com.service.MessageService;

public class MessageT2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MessageService service=new MessageService();
		
		System.out.println(service.getSendInfo(1));
	}

}

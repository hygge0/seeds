package com.test;

import com.service.MessageService;
import com.vo.SendMessage;

public class MessageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MessageService mservice=new MessageService();
		
		SendMessage sm=new SendMessage();
		sm.setEmpId(1);
		sm.setMessageTitle("hello");
		sm.setMessageContent("how are you?");
		sm.setPriority(2);
		
		mservice.sendMessage(sm, new Integer[] {2,3,5,7});
	}

}

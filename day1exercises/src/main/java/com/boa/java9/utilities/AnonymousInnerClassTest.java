package com.boa.java9.utilities;

import com.boa.java9.models.Message;

public class AnonymousInnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//diamond operator in anonymous class
		Message<String> message=new Message<>() {
			
			public String send(String protocol,String info) {
				return "Protocol--->"+protocol+","+"Info--,"+info;
			}
			
		};
		
		System.out.println(message.send("POP", "Credit Card Summary"));
	}

}

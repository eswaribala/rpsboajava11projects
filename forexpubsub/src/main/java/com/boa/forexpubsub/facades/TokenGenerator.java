package com.boa.forexpubsub.facades;

import java.util.Random;

@FunctionalInterface
public interface TokenGenerator {

	String status();
	
	public static String getToken() throws InterruptedException
	{
		
			Thread.sleep(2000);
	
		return "Get Token";
	}

}

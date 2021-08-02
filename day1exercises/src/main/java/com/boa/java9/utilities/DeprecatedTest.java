package com.boa.java9.utilities;

import java.lang.reflect.Method;

import com.boa.java9.models.Trade;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class DeprecatedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Class tradeClass=Trade.class;
		
		Method[] methods=tradeClass.getMethods();
		Method methodDetected=null;
		for(Method method : methods) {
			if(method.getName().equals("nonEconomicTrade")) {
				methodDetected=method;
			}
		}
		
		Deprecated deprecated=methodDetected.getAnnotation(Deprecated.class);
		log.info("Since "+deprecated.since());
		log.info("For Removal "+deprecated.forRemoval());
	}

}

package com.boa.libor.channels;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.SubmissionPublisher;

import com.boa.libor.models.MarketData;

public class LIBORPublisher {
	
	public static void main(String[] args) {
		//Create Publisher
		SubmissionPublisher<MarketData> publisher=new SubmissionPublisher<>();
		//Create Subscriber
		LIBORSubscriber subscriber=new LIBORSubscriber();
		//Register Subscriber
		publisher.subscribe(subscriber);
		
		for(int i=0;i<100;i++) {
			publisher.submit(new MarketData(LocalDate.now(),new Random().nextDouble()));
		}
		
		
	}

}

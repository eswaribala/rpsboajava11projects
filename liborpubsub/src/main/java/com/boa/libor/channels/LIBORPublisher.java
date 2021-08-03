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
		System.out.println(publisher.getSubscribers().size());
		
		final int messageCount=100;
		for(int i=0;i<messageCount;i++) {
			publisher.submit(new MarketData(LocalDate.now(),new Random().nextDouble()));
		}
		while(subscriber.count<messageCount) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		publisher.close();
		
	}

}

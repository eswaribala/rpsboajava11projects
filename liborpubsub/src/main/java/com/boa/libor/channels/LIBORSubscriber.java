package com.boa.libor.channels;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.boa.libor.models.MarketData;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LIBORSubscriber implements Subscriber<MarketData>{

	private Subscription subscription;
	int count=1;
	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		this.subscription=subscription;
		this.subscription.request(1);
		log.info("LIBOR Subscriber Successfully registerd");
		
	}

	@Override
	public void onNext(MarketData item) {
		// TODO Auto-generated method stub
		
		log.info("Item Received,"+count+","+item);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.subscription.request(1);
		count++;
	
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		log.info(throwable.getMessage().toString());
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		log.info("Data Receiving task done.....");
	}

}

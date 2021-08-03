package com.boa.forexpubsub.utilities;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.boa.forexpubsub.models.Transaction;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class TransactionSubscriber implements Subscriber<Transaction>{

	private Subscription subscription;
	public static int count;
	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		log.info("onSubscribe for TransactionSubscriber called");
        this.subscription = subscription;
        this.subscription.request(1); //requesting data from publisher
        System.out.println("onSubscribe for TransactionSubscriber requested 1 transaction");
        count++;
		
	}

	@Override
	public void onNext(Transaction transaction) {
		// TODO Auto-generated method stub
		 log.info("Processed Transaction " + transaction);
	        
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
		log.info("Subscription Done....");
	}
	

}

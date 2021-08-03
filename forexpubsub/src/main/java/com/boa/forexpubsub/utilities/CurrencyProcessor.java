package com.boa.forexpubsub.utilities;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.function.Function;
import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

import com.boa.forexpubsub.models.Currency;
import com.boa.forexpubsub.models.Transaction;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CurrencyProcessor extends SubmissionPublisher<Transaction> 
      implements   Processor<Currency,Transaction>{

	private Subscription subscription;
  
	
	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		 this.subscription = subscription;
	        subscription.request(1);
	}

	@Override
	public void onNext(Currency fromCurrency) {
		// TODO Auto-generated method stub
		 log.info("Processing Transaction " + fromCurrency);
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Transaction transaction=new Transaction();
		transaction.setTransactionId(new Random().nextLong());
		transaction.setFromCurrency(fromCurrency);
		Currency toCurrency=new Currency();
		toCurrency.setCountryCode("INR");
		toCurrency.setDate(LocalDate.now());
		toCurrency.setExchangeRate(fromCurrency.getExchangeRate());
		transaction.setToCurrency(toCurrency);
		transaction.setAmount((long) (new Random().nextInt(20000)*toCurrency.getExchangeRate()));
		transaction.setCharges((long) (transaction.getAmount()*0.05));
		transaction.setFromAccountNo(349563659);
		transaction.setToAccountNo(58439543);		
		submit(transaction);
        subscription.request(1);
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

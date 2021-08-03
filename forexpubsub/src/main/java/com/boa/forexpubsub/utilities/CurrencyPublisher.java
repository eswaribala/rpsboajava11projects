package com.boa.forexpubsub.utilities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import com.boa.forexpubsub.models.Currency;



public class CurrencyPublisher {

	private static List<Currency> getCurrencies(){
		List<Currency> currencyList=new ArrayList<>();
		currencyList.add(new Currency(LocalDate.now(),"USD",72));
		currencyList.add(new Currency(LocalDate.now(),"SAR",17));
		currencyList.add(new Currency(LocalDate.now(),"SGD",45));
		currencyList.add(new Currency(LocalDate.now(),"RGD",14));
		return currencyList;
	}
	
	public static void main(String[] args) {
		
		SubmissionPublisher<Currency> currencyPublisher=new SubmissionPublisher<>();
		CurrencyProcessor processor=new CurrencyProcessor();
		currencyPublisher.subscribe(processor);
		
		TransactionSubscriber transactionSubscriber=new TransactionSubscriber();
		processor.subscribe(transactionSubscriber);
		List<Currency> currencies = getCurrencies();

        // Publish items
        System.out.println("Publishing Currencies to Subscriber");
        currencies.forEach(currencyPublisher::submit);

        // Logic to wait for messages processing to finish
        while (currencies.size() != transactionSubscriber.count) {
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        // Closing publishers
        
        processor.close();
        currencyPublisher.close();
        System.out.println("Exiting the app");
		
	}
}

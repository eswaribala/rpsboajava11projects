package com.boa.forexpubsub.utilities;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import com.boa.forexpubsub.facades.TokenGenerator;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CompletableFutureEnhancementsDemo {

	private static String getTokenFallback() {
		log.info("Invoking fallback.....");
		return "Fallback";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Executor executor=new CompletableFuture<>().defaultExecutor();
		CompletableFuture<String> cFuture=CompletableFuture.supplyAsync(() -> {
			try {
				return TokenGenerator.getToken();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		},
				executor)
				//.orTimeout(1, TimeUnit.SECONDS);
				.completeOnTimeout(getTokenFallback(), 3, TimeUnit.SECONDS);
				
		log.info("Future Done-->"+cFuture.join());
		
	}

}

package com.boa.java9.facades;

import java.time.LocalDate;

import com.boa.java9.models.CreditCard;

public interface CreditCardFacade {

	public default boolean isValid(CreditCard creditCard) {
		return validateCard(creditCard);
	}
	
	private boolean validateCard(CreditCard creditCard) {
		
		boolean status=false;
		if(creditCard.getExpiryDate().isAfter(LocalDate.now())) {
			if((String.valueOf(creditCard.getCvv()).length()==3)){
				if(creditCard.getCardHolderName().length()>5) {
					status=true;
				}
			}
		}
		return status;
	}
	
}

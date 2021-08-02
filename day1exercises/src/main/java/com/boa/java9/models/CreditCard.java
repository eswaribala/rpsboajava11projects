package com.boa.java9.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

	private long cardNo;
	private LocalDate expiryDate;
	private int cvv;
	private String cardHolderName;
}

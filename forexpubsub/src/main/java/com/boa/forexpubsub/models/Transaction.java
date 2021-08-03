package com.boa.forexpubsub.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	private long transactionId;
	private Currency fromCurrency;
	private Currency toCurrency;
	private long charges;
	private long fromAccountNo;
	private long toAccountNo;
	private long amount;
}

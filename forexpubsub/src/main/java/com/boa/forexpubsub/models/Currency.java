package com.boa.forexpubsub.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    private LocalDate date;  
	private String countryCode;
	private double exchangeRate;
	
}

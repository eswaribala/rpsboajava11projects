package com.boa.java9.utilities;

import java.time.LocalDate;
import java.util.Random;

import com.boa.java9.models.CreditCard;
import com.boa.java9.models.CreditCardImpl;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class PrivateInterfaceMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CreditCardImpl ccImpl=new CreditCardImpl();
		log.info("Response  "+ccImpl.isValid(new CreditCard(8999666+new Random().nextInt(1000000),
				LocalDate.of(1900+new Random().nextInt(140),
						1+new Random().nextInt(10) , 1+new Random().nextInt(27)),
				100+new Random().nextInt(999),"CCHolder"+new Random().nextInt(10000))));
	}

}

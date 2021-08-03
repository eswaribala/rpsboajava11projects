package com.boa.java9.utilities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.boa.java9.models.Customer;

public class ImmutableTest {
	private static List<Customer> createCustomers(){
	List<Customer> customerList=new ArrayList<Customer>();
	
	for(int i=0;i<100;i++) {
		customerList.add(new Customer(new Random().nextInt(10000),
				"Customer"+i, LocalDate.of(1900+new Random().nextInt(120),
						1+new Random().nextInt(10) , 1+new Random().nextInt(27))));
	}
	
	return customerList;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       List<Customer> customers=List.copyOf(createCustomers());
       //immutable list does not allow modifications
	   customers.add(new Customer());	
		
	}

}

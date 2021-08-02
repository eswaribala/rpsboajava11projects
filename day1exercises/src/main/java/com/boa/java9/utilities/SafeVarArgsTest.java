package com.boa.java9.utilities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.boa.java9.models.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SafeVarArgsTest {
    @SafeVarargs 
	private void readCustomers(int i, List...customers) {
		log.info("Received Message Random Value:"+String.valueOf(i));
		for(List<Customer> customer:customers) {
			
			log.info(customer.toString());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Customer> customerList=new ArrayList<Customer>();
		
		for(int i=0;i<100;i++) {
			customerList.add(new Customer(new Random().nextInt(10000),
					"Customer"+i, LocalDate.of(1900+new Random().nextInt(120),
							1+new Random().nextInt(10) , 1+new Random().nextInt(27))));
		}
		
	   new SafeVarArgsTest().readCustomers(new Random().nextInt(100000), customerList);
		
	}

}

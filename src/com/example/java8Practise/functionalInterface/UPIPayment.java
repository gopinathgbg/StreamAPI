package com.example.java8Practise.functionalInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface
public interface UPIPayment {

	 default void getCredit() {};
	
	 void doPayment(String sourse,String dest) ;
	
	static String dataPattern(String pattern) {
		 SimpleDateFormat dateFormat= new SimpleDateFormat(pattern);
		 return dateFormat.format(new Date());
	}	
}
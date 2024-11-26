package com.example.java8Practise.LambdaExpression;

import java.util.function.Function;

public class TestClass {

	public static void main(String[] args) {
	
	//	MyFunctionalInterface testref= (i) ->i;
	//	System.out.println("Result: "+testref.testmethod(14));
	
	/*
	 * MyFunctionalInterface testmethod=( s1,s2) -> { return s1+":"+s2; };
	 * 
	 * System.out.println(testmethod.toString());
	 */		
		// Functional functinoal Interface demo Example **************************************************************
		
		Function<Integer, Integer> fun= (i) -> i;
		System.out.println(fun.apply(4));
		
		Function<Integer, String> fun1= (i) -> "Output==>"+i;
		System.out.println(fun1.apply(4));
	}
}

package com.example.MultiThreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SyncronizersExamples {

	public static void main(String[] args) {
		Semaphore sem= new Semaphore(0);
		System.out.println(sem.toString());
		CountDownLatch cdl =new CountDownLatch(0);
		

	}

}

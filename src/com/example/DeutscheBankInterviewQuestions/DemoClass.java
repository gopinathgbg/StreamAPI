package com.example.DeutscheBankInterviewQuestions;

public class DemoClass {

	public static void main(String[] args) {

	}

	public class Account {

		private final double accountBalance = 0;
		private final int accountId = 0;

		public double getAccountBalance() {
			return accountBalance;
		}

		public int getAccountId() {
			return accountId;
		}

		public Department getDepartment() {
			return department;
		}

		final Department department = null;

	}
}

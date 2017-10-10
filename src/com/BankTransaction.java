package com;

//	BankTransaction Class
public class BankTransaction {
	//	Variable where Account details are stored
	double balance;

	//	Synchronized (Thread Safe) Method to withdraw from the Account and also throws Exception
	public synchronized void withdraw(double amt) throws Exception {
		if (balance <= 0) {												//	If the balance is less than 0 throws exception
			throw new Exception("ATM does not have enough cash....");
		} else if (amt > balance) {											//	If withdraw amount is greater than account balance amount throws exception
			throw new Exception("You are trying to withdraw more cash than the ATM has....");
		} else {															//	If the above conditions are satisfied then the user entered amt will be withdraw
			balance = balance - amt;
			System.out.println("Amount " + amt + " has been withdrawed Successfully.");
			System.out.println("Balance amount is : " + balance);
		}
	}

	//	Synchronized (Thread Safe) Method to Deposit amount into Account
	public synchronized void deposit(double amt) {
		balance = balance + amt;											//	User entered amount will added to the Account balance
		System.out.println("Amount " + amt + " has been deposited Successfully.");
		System.out.println("Balance amount is : " + balance);
	}
}
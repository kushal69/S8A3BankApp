package com;

import java.util.Scanner;

//	Main Bank Class
public class Bank {
	// Main Method
	public static void main(String args[]){
		//	Creating 3 bank objects
		BankTransaction bankAtmICICI = new BankTransaction();
		BankTransaction bankAtmHDFC = new BankTransaction();
		BankTransaction bankAtmSBI = new BankTransaction();
		
		Scanner userInput = new Scanner(System.in);									//	Scanner Class object to get the user input
		int choice = 0;																//	Variable to get the choice from the user
		int bankChoice = 0;															//	Variable to get the choice from the user
		double amount = 0;															//	Variable to get the amount from the user

		while (true) {																//	Loop for the Banks choice
			System.out.println("--------------------------------------------------------------------------------");
			System.out.print("Choose 1.ICICI Bank 2.HDFC Bank 3.SBI Bank 4.Exit : ");
			bankChoice = userInput.nextInt();										//	Gets the bank choice from the User

			if (bankChoice <= 3) {													//	Condition to check for the valid bank choice
				while (true) {														//	Loop for the Bank transaction choice
					try {															//	Try Block Added
						System.out.println("--------------------------------------------------------------------------------");
						System.out.print("Choose 1.Deposit 2.Withdraw 3.Exit : ");
						choice = userInput.nextInt();								//	Gets the Transaction choice
						if (choice == 1) {											//	If 1 then Deposit
							System.out.print("Enter the amount to Deposit : ");
							amount = userInput.nextDouble();						//	Gets the Deposit Amount
							if (amount > 0) {										//	Checks for valid user entered amount
								if (bankChoice == 1) {								//	Based on bank choice respective object's deposit method will be called
									bankAtmICICI.deposit(amount);
								} else if (bankChoice == 2) {
									bankAtmHDFC.deposit(amount);
								} else {
									bankAtmSBI.deposit(amount);
								}
							} else {
								System.out.println("Please enter valid amount to deposite");
							}
						} else if (choice == 2) {									//	If 2 then Withdraw
							System.out.print("Enter the amount to Withdraw : ");
							amount = userInput.nextDouble();						//	Gets the Withdraw Amount
							if (amount > 0) {										//	Checks for valid user entered amount
								if (bankChoice == 1) {								//	Based on bank choice respective object's withdraw method will be called
									bankAtmICICI.withdraw(amount);
								} else if (bankChoice == 2) {
									bankAtmHDFC.withdraw(amount);
								} else {
									bankAtmSBI.withdraw(amount);
								}
							} else {
								System.out.println("Please enter valid amount to Withdraw");
							}
						} else if (choice == 3) {									//	If 3 then Exit from the particular Bank's loop
							System.out.println("Bank Transactions are completed.");
							break;
						} else {
							System.out.println("Please enter valid choice.......");
							break;
						}
					} catch (Exception e) {									//	Catch block to handle the Bank Exception and to Continue the Bank flow
						System.out.println(e.getMessage());							//	Prints the error message of the Bank Exception 
					}
				}
			} else if (bankChoice == 4) {											//	If 4 Then to exit from the Bank Choice Loop
				System.out.println("Exited from the Bank...");
				userInput.close();													//	Closing the Scanner Object
				break;
			} else {
				System.out.println("Enter a Valid Bank Choice...");
			}
		}
	}
}



import java.util.Scanner;

public class Bank {
	private int id;
	private double balance;
	private int banksLoaned;
	BorrowerBank borrowBankArray[];

	/*
	 * Three parameter constructor for the class, sets the balance, id and the number of banks loaned
	 */
	Bank(double tempBalance, int tempBanksLoaned, int tempId) {
		balance = tempBalance;
		banksLoaned = tempBanksLoaned;
		id = tempId;
	}

	/*
	 * return the number of banks loaned
	 */
	public int getBanksLoaned() {
		return banksLoaned;
	}

	
	/*
	 * Return the amount of balance
	 */
	public double getBalance() {
		return balance;
	}

	
	/*
	 * This function accepts an integer, otherwise gives a warning.
	 */
	public static int acceptNumberInt() {
		int num = 0;
		Scanner x = new Scanner(System.in);
		String str = "";

		boolean answer = false;

		while (answer == false) {
			str = x.next();
			try {
				num = Integer.parseInt(str);
				answer = true;

			} catch (NumberFormatException e) {
				answer = false;
				System.out.println("Invalid Input, try entering a number!!!");

			}
		}

		return num;
	}

	
	/*
	 * This function accepts a double, otherwise gives a warning.
	 */
	public static double acceptNumberDouble() {
		double num = 0;
		Scanner x = new Scanner(System.in);
		String str = "";

		boolean answer = false;

		while (answer == false) {
			str = x.next();
			try {

				num = Double.parseDouble(str);
				answer = true;

			} catch (NumberFormatException e) {
				answer = false;
				System.out.println("Invalid Input, try entering a number!!!");

			}
		}

		return num;
	}

	
	/*
	 * Accepts the total number of banks
	 */
	public static int NoOfBanks() {
		System.out.println("Enter the number of banks: ");
		int numberOfBanks = acceptNumberInt();

		return numberOfBanks;
	}

	
	/*
	 * Sets the Asset Amount for all the banks
	 */
	public static double AssetAmount() {
		System.out.println("Enter the Asset limit: ");
		double assetMoney = acceptNumberDouble();
		return assetMoney;
	}

	/*
	 * Accept the balance of the bank, the number of banks loaned, their Id and amount loaned
	 * Stores all this data in an array
	 */
	public static Bank[] information(int numberOfBanks) {

		Bank array[] = new Bank[numberOfBanks];
		for (int i = 0; i < numberOfBanks; i++) {
			System.out.print("Bank #" + i + " ");
			System.out.println("Balance: ");
			double tempBalance = acceptNumberDouble();
			System.out.println("Number of banks Loaned: ");

			boolean bankLoaned = false;
			int tempBanksLoaned = 0;
			while (bankLoaned == false) {
				tempBanksLoaned = acceptNumberInt();

				if (tempBanksLoaned < 0 ) {
					System.out.println("Invalid Input try again!!!");
				} else {
					bankLoaned = true;
				}

			}
			array[i] = new Bank(tempBalance, tempBanksLoaned, i);

			array[i].borrowBankArray = new BorrowerBank[tempBanksLoaned];

			for (int j = 0; j < tempBanksLoaned; j++) {
				array[i].borrowBankArray[j] = new BorrowerBank();
				System.out.println("Bank ID: ");
				boolean checkId = false; // boolean to validate the id enetered
				int tempId = 0;
				while (checkId == false) {

					tempId = acceptNumberInt();

					if (tempId >= numberOfBanks || tempId < 0 || tempId == i) {
						System.out.println("Invalid Id try again!!!");
					} else {
						checkId = true;
					}

				}

				array[i].borrowBankArray[j].setId(tempId);
				System.out.println("Amount: ");
				double tempAmountBorrowed = acceptNumberDouble();
				array[i].borrowBankArray[j].setAmountBorrowed(tempAmountBorrowed);
			}

		}
		return array;
	}

	/*
	 * Iterate through all the banks to find the unsafe banks and 
	 * stores the id of unsafe banks in an array
	 */
	public static int[] danger(Bank[] array, double assetLimit) {
		double total = 0;

		int dangerBank[] = new int[array.length]; // the danger banks won't be more that number of original banks

		for (int x = 0; x < dangerBank.length; x++) {
			dangerBank[x] = -1; // make safe empty safe values
		}
		int count = 0; // index of danger array
		int number = 0;
		while (number < array.length) {
			for (int i = 0; i < array.length; i++) {
				total = array[i].getBalance();

				for (int j = 0; j < array[i].borrowBankArray.length; j++) {
					boolean answer = false;
					for (int k = 0; k < dangerBank.length; k++) {
						if (array[i].borrowBankArray[j].getId() == dangerBank[k]) {
							answer = true;
						}
					}
					if (answer == false) {
						total += array[i].borrowBankArray[j].getAmountBorrowed();
					}

				}

				if (total < assetLimit) {
					boolean finalCheck = false;
					for (int r = 0; r < dangerBank.length; r++) {
						if (i == dangerBank[r]) {
							finalCheck = true;
						}
					}

					if (finalCheck == false) {
						dangerBank[count] = i; // id is equal to their number

						count++;
					}
				}
			}
			number++;
		}

		return dangerBank;
	}

	
	/*
	 * Calling all the functions to accept the number of banks, asset amount, the Id of the bank they lend money to
	 * and amount.
	 * Then process on it to find the unsafe banks 
	 */
	public static void main(String[] args) {
		int numOfBanks = NoOfBanks();
		double asset = AssetAmount();
		Bank bankArray[] = information(numOfBanks);
		int array[] = danger(bankArray, asset);
		boolean dangerCheck = true; // boolean to check if there is any unsafe bank
		System.out.print("Unsafe banks are ");
		for (int i = 0; i < array.length; i++) {
			if (array[i] != -1) {
				System.out.print(array[i] + " ");
				dangerCheck = false;
			}

		}
		if (dangerCheck) {
			System.out.println("None");
		}

	}
}



package workshop;

import java.util.Scanner;
import workshop.Account;

public class atm {

	public static void main(String[] args) {

		boolean button = true;
		Account exp[] = initalizeAccounts();
		boolean infinteVariable1 = true;
		boolean infinteVariable2 = true;
		while (infinteVariable1) {
			int id = inputId(exp);
			infinteVariable2 = true;
			while (infinteVariable2) {
				menu();
				infinteVariable2 = menuImplemention(exp[id]);
			}
		}

	}

	public static void menu() {
		// System.out.println("Enter the id: ");
		System.out.println("Main Menu");
		System.out.println("1:check balance");
		System.out.println("2:withdrawn");
		System.out.println("3:deposit");
		System.out.println("4:exit");
		System.out.print("Enter a choice:");
	}

	public static int inputId(Account[] a) {
		Scanner x = new Scanner(System.in);
		System.out.print("Enter an id:");
		boolean check = true;
		boolean check2 = true;
		int answer = 0;
		while (check == true) {
			answer = acceptNumber();

			for (int i = 0; i < 10; i++) {
				if (answer == a[i].getId()) {
					check = false;
					check2 = false;
					break;
				}
			}
			if (check2) {
				System.out.println("Enter the id again :");
				check = true;
			}
		}
		return answer;
	}

	public static Account[] initalizeAccounts() {
		// after creating the array we have to initalize it too.
		Account[] acc = new Account[10];
		for (int i = 0; i < acc.length; i++) {
			acc[i] = new Account();
			acc[i].modifyId(i);
			acc[i].modifyBalance(100);
		}
		return acc;
	}

	public static boolean menuImplemention(Account a) {
		boolean returnBool = true;
		Scanner s = new Scanner(System.in);
		int answer = s.nextInt();
		switch (answer) {
		case 1:
			System.out.println("The balance is: " + a.getBalance());
			break;
		case 2:
			System.out.print("Enter an amount to withdraw: ");
			double withdrawnCash = s.nextDouble();
			a.withdraw(withdrawnCash);
			break;
		case 3:
			System.out.print("Enter an amount to deposit: ");
			double depositCash = s.nextDouble();
			a.deposit(depositCash);
			break;
		case 4:
			returnBool = false; // to break the inner infinte loop in main
			System.out.println();
			break;
		default:
			System.out.println("Invalid option, try again.");
		}

		return returnBool;
	}

	public static int acceptNumber() {
		int num = 0;
		Scanner x = new Scanner(System.in);
		String str = "";

		boolean answer = false;

		while (answer == false) {
			str = x.next();
			try {
				num = Integer.parseInt(str);
				answer = true;

			} catch (NumberFormatException err) {
				answer = false;
				System.out.println("Invalid Input, try entering a number!!!");
			}
		}

		return num;
	}

}

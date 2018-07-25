package workshop4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NameRanks {

	static String flag1 = "0";
	static String[][] boys = new String[1000][2];
	static String girls[][] = new String[1000][2];

	/* This function accept only integer nothing else*/
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

	/* This function questions user and store their answer into an array*/
	public static String[] display() {
		Scanner s = new Scanner(System.in);
		String[] arr = new String[3];
		int year = 0;
		while (year < 2001 || year > 2010) {
			System.out.println("Enter the Year(2001-2010):");
			year = acceptNumberInt();
			if (year < 2001 || year > 2010) {
				System.out.println("Record for this year is not available!!!");
			}
		}
		arr[0] = year + "";

		arr[1] = "x";
		while (arr[1].compareTo("M") != 0 && arr[1].compareTo("m") != 0 && arr[1].compareTo("F") != 0
				&& arr[1].compareTo("f") != 0) {
			System.out.println("Enter the gender(M/F):");
			arr[1] = s.next().charAt(0) + "";

			if (arr[1].compareTo("M") != 0 && arr[1].compareTo("m") != 0 && arr[1].compareTo("F") != 0
					&& arr[1].compareTo("f") != 0) {
				System.out.println("Please enter the right symbol!!!");
			}
		}

		System.out.println("Enter the name:");
		arr[2] = s.next();

		return arr;
	}

	/*
	 * This function stores the data into two different array, one for girl and
	 * another for boys. Then search through the array to look for the name. If the
	 * year is same in another search then it won't go through the .txt file, rather
	 * than that it will then search through the arrays, which saves time.
	 */
	public static void search() {

		Scanner input = null;

		String array[] = display();
		String fileName = "C:\\Users\\pranshu\\eclipse\\workshop4\\src\\workshop4\\file\\babynamesranking" + array[0]
				+ ".txt";
		String flag2 = array[0];

		if (flag2.compareTo(flag1) != 0) {
			flag1 = flag2;
			try {
				int index = 0;
				input = new Scanner(new File(fileName));
				while (input.hasNext()) {
					String tmp = input.useDelimiter("\r\n").next(); // reading the whole line
					String[] tempArray = tmp.split(" ");

					for (int i = 0; i < tempArray.length; i++) {
						tempArray[i] = tempArray[i].trim();
					}

					int count = 0;

					for (int j = 0; j < tempArray[1].length(); j++) {
						if ((tempArray[1].charAt(j) > 64 && tempArray[1].charAt(j) < 91)
								|| (tempArray[1].charAt(j) > 96 && tempArray[1].charAt(j) < 123)) {
							count++;
						}
					}

					boys[index][0] = tempArray[1].substring(0, count);
					boys[index][1] = tempArray[1].substring(count);
					girls[index][0] = tempArray[2];
					girls[index][1] = tempArray[3];
					index++;
				}

			} catch (FileNotFoundException e) {
				System.out.println("Can't open the File!!!");
			}
		}

		if (array[1].compareTo("M") == 0 || array[1].compareTo("m") == 0) {
			int boyFlag = 0;
			for (int z = 0; z < boys.length; z++) {
				if (boys[z][0].compareTo(array[2]) == 0) {
					System.out.println(
							"Boy named " + array[2] + " is ranked #" + boys[z][1].trim() + " in year " + array[0]);
					boyFlag = 1;
					break;
				}
			}
			if (boyFlag == 0) {
				System.out.println("No such record found!!!");
			}
		} else {
			int girlFlag = 0;
			for (int c = 0; c < girls.length; c++) {
				if (girls[c][0].compareTo(array[2]) == 0) {
					girlFlag = 1;
					System.out.println(
							"Girl named " + array[2] + " is ranked #" + girls[c][1].trim() + " in year " + array[0]);
					break;
				}
			}
			if (girlFlag == 0) {
				System.out.println("No such record found!!!");
			}
		}

	}

	/* Main is just to call the search function till the time user wants to stop*/
	public static void main(String[] args) {
		boolean flag = true;
		while (flag) {
			search();
			boolean flag2 = true;
			while (flag2) {
				System.out.println("Enter another inquiry?");
				Scanner s = new Scanner(System.in);
				char answer = s.next().charAt(0);
				if (answer == 'y' || answer == 'Y') {
					flag2 = false;
				} else if (answer == 'n' || answer == 'N') {
					flag = false;
					flag2 = false;
				} else {
					System.out.println("False input try again!!!");
				}
			}
		}
	}
}

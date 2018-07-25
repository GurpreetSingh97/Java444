


package workshop;

import java.util.Scanner;

public class Locations {
	int row;
	int column;
	double maxValue;

	public static void main(String[] args) {
		int arrayRow = 0;
		int arrayColumn = 0;

		System.out.println("Enter the number of rows and columns in the array: ");
		while (arrayRow <= 0 || arrayColumn <= 0) {
			arrayRow = acceptNumber();
			arrayColumn = acceptNumber();
			if (arrayRow <= 0 || arrayColumn <= 0) {
				System.out.println("Row and column number cannot be 0, Enter them again!!!");
			}

		}
		double array[][] = new double[arrayRow][arrayColumn];

		System.out.println("Enter the elemets");

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = acceptNumber();
			}
		}

		Locations x = new Locations();
		x = locateLargest(array);
		System.out.println(
				"The locations of the largest element is " + x.maxValue + " at " + "(" + x.row + " " + x.column + ")");

	}

	// function to accept the user input in number
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

			} catch (NumberFormatException e) {
				answer = false;
				System.out.println("Invalid Input, try entering a number!!!");

			}
		}

		return num;
	}

	// the function to find the maximum value and coordinates
	public static Locations locateLargest(double[][] a) {
		Locations obj = new Locations();
		double max = Integer.MIN_VALUE;
		int row = 0;
		int column = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > max) {
					max = a[i][j];
					column = j;
					row = i;
				}
			}
		}
		obj.maxValue = max;
		obj.row = row;
		obj.column = column;

		return obj;
	}
}

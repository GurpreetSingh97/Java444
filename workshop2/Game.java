





import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

	/*
	 * this function create the asterisk strings as long as the size of original string.
	 */
	public static String createAstStr(String str) {
		String ast = "";
		for (int i = 0; i < str.length(); i++) {
			ast += "*";
		}
		return ast;
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
	 * This function compares the character input by the user with the original string and 
	 * if it is in the string then put that character at the right place in the asterisk String
	 * and return the new asterisk string
	 * This function also keep track of the incorrect attempts
	 */
	public static String[] compare(String ast, String str, char s, int count) {
		String returnArray[] = new String[2];
		boolean flag = true;
		for (int j = 0; j < str.length(); j++) {

			if (s == ast.charAt(j)) {
				System.out.println(s + " is already in the word");
				flag = false;
				break;
			} else if (str.charAt(j) == s) {
				if (j == 0) {
					ast = s + ast.substring(j + 1);
				} else if (j == str.length() - 1) {
					ast = ast.substring(0, ast.length() - 1) + s;
				} else {
					ast = ast.substring(0, j) + s + ast.substring(j + 1);
				}
				flag = false;
			}

		}

		if (flag == true) {
			count++;
		}

		returnArray[0] = "" + count;
		returnArray[1] = ast;
		return returnArray;

	}

	
	/*
	 * This function shows the menu for the game and depending upon the option
	 * picks a random word. If the answer is 1 then from an array, if it's 2 then from a
	 * file, otherwise gives a warning.
	 */
	public static String menu() {
		String str = "";
		System.out.println("Hangman Game");
		System.out.println();
		System.out.println("Press 1 to run game with randomly generated word.");
		System.out.println();
		System.out.println("Press 2 to run game by reading the word from the text file");

		int number = 0;
		boolean check = false;

		while (check == false) {
			number = acceptNumberInt();
			switch (number) {
			case 1:
				str = randomString();
				check = true;
				break;
			case 2:
				
				str = randomStringFile();
				check = true;
				break;
			default:
				System.out.println("invalid answer, try again!!!");
				break;

			}
		}
		return str;
	}

	
	/*
	 * This function chooses a random string from an Array
	 */
	public static String randomString() {
		String words[] = { "computer", "laptop", "swimming", "flying", "money", "canada" };
		int index = (int) (Math.random() * words.length);
		String randomStr = words[index];
		return randomStr;
	}

	/*
	 * This function chooses a random string from a file
	 */
	public static String randomStringFile() {
		String str= "";
		Scanner input = null;
		Scanner inp = null;
		try {
			input = new Scanner(new File("C:\\Users\\pranshu\\eclipse-workspace\\Workshop2\\src\\hangman.txt"));
			inp = new Scanner(new File("C:\\Users\\pranshu\\eclipse-workspace\\Workshop2\\src\\hangman.txt"));
			int numOfWords = 0;

			// counting the number of words in textFile
			while (inp.hasNext()) {
				String temp = inp.useDelimiter(" ").next();
				numOfWords++;
			}

			String arr[] = new String[numOfWords];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = input.useDelimiter(" ").next();
			}

			int num = (int) (Math.random() * arr.length);
			str = arr[num];

		} catch (FileNotFoundException e) {
			System.out.println("File do not exist!!!");
		}
		return str;
	}
	
	
	/*
	 * Here we are calling the functions in a certain sequence and processing the character enter by the user
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean answer = false;
		while (answer == false) {
			int incorrectCount = 0;
			String cmpArray[] = new String[2];
			String randomStr = menu();

			String ast = createAstStr(randomStr);

			while (randomStr.equals(ast) == false) {
				System.out.print("(Guess) Enter a letter in word " + ast + ":");

				char character = s.next().charAt(0);

				cmpArray = compare(ast, randomStr, character, incorrectCount);
				incorrectCount = Integer.parseInt(cmpArray[0]);
				ast = cmpArray[1];

			}

			System.out.println("The word is " + randomStr + " You missed " + incorrectCount + " time");
			System.out.print("Do you want to guess another word? Enter y or n>");
			char ans = s.next().charAt(0);
			if (ans == 'n' || ans == 'N') {
				answer = true;
			}
		}
	}

}

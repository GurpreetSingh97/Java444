package workshop4;

import java.util.Scanner;

public class ConnectFour {
	static String[][] board = new String[6][7];

	/*
	 * This function fill the board as empty
	 */
	static void fillBoardArray() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j <= board.length; j++) {
				board[i][j] = "O";
			}
		}
	}

	/*
	 * Displays all the element of the 2D array in a desirable format
	 */
	public static void displayBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j <= board.length; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}
	}

	/*
	 * This function accepts only integer
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
	 * returns a boolean to check if user should be given another chance because of
	 * filled column
	 */
	public static String fillDisk(String Disk) {
		if (Disk.compareTo("R") == 0) {
			System.out.println("Drop a Red disk at column (0-6):");
		} else {
			System.out.println("Drop a Yellow disk at column (0-6):");
		}

		int column = acceptNumberInt();
		while (column < 0 || column > 6) {
			System.out.println("Limit exceeded, try again!!!");
			column = acceptNumberInt();
		}

		String status = "filled";
		int row = board.length - 1;
		while (row >= 0) {
			if (board[row][column].compareTo("O") == 0) {
				board[row][column] = Disk;
				status = "empty";
				break;
			} else {
				row--; // going up every time it fails to fill the disk
			}
		}
		if (status.compareTo("filled") == 0) {
			System.out.println("Column is full");
		}
		return status;
	}

	/*
	 * checks the 2D array up-to-down diagonally for winner
	 */
	public static String UpToDownDiagonal() {
		int row = 6;
		String arr[] = new String[2];
		for (int k = 0; k < row * 2; k++) {
			arr[0] = "nothing";
			arr[1] = "nothing";
			int even = 0;
			int count = 0;
			for (int j = 0; j <= k; j++) {
				int i = k - j;
				if (i < row && j < row) {
					if (even % 2 == 0) {
						arr[0] = board[i][j];
					} else {
						arr[1] = board[i][j];
					}
					if (arr[0].compareTo(arr[1]) == 0 && board[i][j].compareTo("O") != 0) {
						count++;
					} else {
						count = 0;
					}

					for (int p = 1; p < 4; p++) {
						if (i == p && j == 5 && count != 3) {
							if (arr[0] == board[p - 1][6] && board[i][j].compareTo("O") != 0) {
								count++;
							} else {
								count = 0;
							}
						}
					}

					if (count == 3) {
						return arr[0];
					}
				}
				even++;
			}
		}
		return "none";
	}

	/*
	 * Check the lower half of 2D array down-to-up diagonally for winner
	 */
	public static String DownToUpDiagonalLower() {

		int row = 6;
		String arr[] = new String[2];
		int x = 0;
		for (int i = ((row - 1)); i >= 0; i--) {
			arr[0] = "nothing";
			arr[1] = "nothing";
			int even = 0;
			int count = 0;
			int n = 0;
			for (int j = 0; j <= x; j++) {
				int z = x - j;

				if (i < row && j < row) {
					if (even % 2 == 0) {
						arr[0] = board[i + n][j];
					} else {
						arr[1] = board[i + n][j];
					}

					if (arr[0].compareTo(arr[1]) == 0 && arr[0].compareTo("O") != 0) {
						count++;

					} else {
						count = 0;
					}

					if (count == 3) {
						return arr[0];
					}

				}
				even++;
				n++;
			}

			x++;
		}
		return "none";
	}

	/*
	 * Check the upper half of 2D array down-to-up diagonally for winner
	 */
	public static String DownToUpDiagonalUpper() {

		int row = 6;
		String arr[] = new String[2];
		int x = 0;
		for (int i = ((row - 1)); i > 0; i--) {
			arr[0] = "nothing";
			arr[1] = "nothing";
			int even = 0;
			int count = 0;
			int n = 0;
			for (int j = 0; j <= x; j++) {
				int z = x - j;

				if (i < row && j < row) {
					if (even % 2 == 0) {
						arr[0] = board[j][i + n];
					} else {
						arr[1] = board[j][i + n];
					}

					if (arr[0].compareTo(arr[1]) == 0 && arr[0].compareTo("O") != 0) {
						count++;

					} else {
						count = 0;
					}

					for (int p = 2; p < 5; p++) {
						if (j == p && (i + n) == 5 && count != 3) {
							if (arr[0] == board[p + 1][6] && arr[0].compareTo("O") != 0) {
								count++;
							} else {
								count = 0;
							}
						}
					}

					if (count == 3) {
						return arr[0];
					}

				}
				even++;
				n++;
			}

			x++;
		}
		return "none";
	}

	/*
	 * Checks the 2D array horizontally for the winner
	 */
	public static String checkHorizontal() {
		String winner = "none";
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length - 1; j++) {
				if (board[i][j].compareTo(board[i][j + 1]) == 0 && board[i][j].compareTo("O") != 0) {
					count++;
				} else {
					count = 0;
				}
				if (count == 3) {
					winner = board[i][j];
					break;
				}
			}

		}
		return winner;
	}

	/*
	 * Checks the 2D array vertically for the winner
	 */
	public static String checkVerticle() {
		String winner = "none";
		int count = 0;

		for (int j = 0; j < board[0].length; j++) {

			for (int i = 0; i < board.length - 1; i++) {
				if (board[i][j].compareTo(board[i + 1][j]) == 0 && board[i][j].compareTo("O") != 0) {
					count++;
				} else {
					count = 0;
				}
				if (count == 3) {
					winner = board[i][j];
					break;
				}

			}

		}
		return winner;
	}

	/*
	 * Check all the possible diagonals of the 2D array for the winner 
	 * using UpToDownDiagonal, DownToUpDiagonalLower and DownToUpDiagonalUpper function.
	 */
	public static String checkDiagonally() {
		String winner = "none";
		winner = UpToDownDiagonal();

		if (winner.compareTo("none") == 0) {
			winner = DownToUpDiagonalLower();
		}

		if (winner.compareTo("none") == 0) {
			winner = DownToUpDiagonalUpper();
		}

		return winner;
	}

	/* 
	 * Prompt the user to through their disk, check for winner and display
	 */
	public static void main(String[] args) {

		fillBoardArray();

		int winnerFound = 12;
		String disk = "R"; // starting disk is R
		int count = 0;
		while (winnerFound > 0 && count < board.length * board[0].length) {

			String status = fillDisk(disk);

			displayBoard();
			String winnerV = checkVerticle();
			String winnerH = checkHorizontal();
			String winnerD = checkDiagonally();
			if (winnerV.compareTo("none") != 0) {
				System.out.println("The " + winnerV + " player won.");
				break;

			} else if (winnerH.compareTo("none") != 0) {
				System.out.println("The " + winnerH + " player won.");
				break;
			}

			else if (winnerD.compareTo("none") != 0) {
				System.out.println("The " + winnerD + " player won.");
				break;
			}

			if (status.compareTo("empty") == 0) {
				if (count % 2 == 0) {
					disk = "Y";
				} else {
					disk = "R";
				}
				count++;
			}

		}

		if (count == board.length * board[0].length) {
			System.out.println("Draw");

		}

	}
}

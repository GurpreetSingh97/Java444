



package workshop3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class FileButton {
	static int position = 0;

	//this function count the total number of lines
	public int lineCount() {
		Scanner tempInp = null;
		int lineCount = 0;
		try {
			tempInp = new Scanner(new File("./src/workshop3/Address.txt"));
			while (tempInp.hasNext()) {
				String tmp = tempInp.useDelimiter("\r\n").next();
				lineCount++;
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
		return lineCount;
	}
	
	//append the data into the file
	public void add(String str) throws Exception {
		File file = new File("Address.txt");
		long length = file.length();

		RandomAccessFile r = new RandomAccessFile(file, "rw");

		r.seek(length);
		r.writeBytes(str);
		r.close();

	}

	//returns the data at first position of the file
	public String[] first() throws Exception {
		Scanner inp = null;
		String[] array = new String[5];
		position = 1;
		try {
			inp = new Scanner(new File("C:\\Users\\pranshu\\eclipse-workspace\\Workshop3\\Address.txt"));

			for (int i = 0; i < array.length - 1; i++) {
				array[i] = inp.useDelimiter(",").next();
			}

			array[array.length - 1] = inp.useDelimiter("\r\n").next().substring(1);

		} catch (FileNotFoundException ex) {
			System.out.println("The file is missing!!!");
		}

		return array;
	}

	//returns the data at the last position of the file
	public String[] last() throws Exception {

		String array[] = new String[5];
		int lineCount = 0;
		try {
			lineCount = lineCount();

			Scanner inp = null;
			inp = new Scanner(new File("C:\\Users\\pranshu\\eclipse-workspace\\Workshop3\\Address.txt"));
			for (int i = 0; i < lineCount - 1; i++) {
				String temp = inp.useDelimiter("\r\n").next();

			}

			for (int j = 0; j < array.length - 1; j++) {
				array[j] = inp.useDelimiter(",").next();
			}

			array[array.length - 1] = inp.useDelimiter("\r\n").next().substring(1);

		} catch (FileNotFoundException ex) {
			System.out.println("Find not found!!!");
		}
		position = lineCount;
		System.out.println("last " + position);
		return array;
	}

	//returns the next data
	public String[] next() throws Exception {
		String array[] = new String[5];
		if (position != lineCount()) {
			Scanner inp = null;

			try {
				inp = new Scanner(new File("C:\\Users\\pranshu\\eclipse-workspace\\Workshop3\\Address.txt"));
				for (int i = 0; i < position; i++) {
					String temp = inp.useDelimiter("\r\n").next();
				}

				for (int j = 0; j < array.length - 1; j++) {
					array[j] = inp.useDelimiter(",").next();
				}

				array[array.length - 1] = inp.useDelimiter("\r\n").next().substring(1);
				position++; // how to increase its value

			} catch (FileNotFoundException ex) {
				System.out.println(ex);
			}
		} else {
			System.out.println("No next Line");
		}

		return array;
	}

	//returns the previous data
	public String[] previous() throws Exception {

		String array[] = new String[5];
		if (position != 0) {
			Scanner inp = null;

			try {
				inp = new Scanner(new File("C:\\Users\\pranshu\\eclipse-workspace\\Workshop3\\Address.txt"));

				for (int i = 0; i < position - 1; i++) {
					String temp = inp.useDelimiter("\r\n").next();
				}

				for (int j = 0; j < array.length - 1; j++) {
					array[j] = inp.useDelimiter(",").next();
				}

				array[array.length - 1] = inp.useDelimiter("\r\n").next().substring(1);
				position--; // how to increase its value

			} catch (FileNotFoundException ex) {
				System.out.println(ex);
			}
		} else {
			System.out.println("No previous Line");
		}
		return array;
	}

	//update the data in the file
	public void update(String str) throws Exception {
		Scanner inp = null;

		try {
			inp = new Scanner(new File("C:\\Users\\pranshu\\eclipse-workspace\\Workshop3\\Address.txt"));
			File file = new File("Address.txt");
			RandomAccessFile r = new RandomAccessFile(file, "rw");

			r.seek(95 * (position-1));
			r.writeBytes("\r\n");
			for (int x = 0; x < 95; x++) {
				r.writeBytes(" ");
			}
			
			r.seek(95 * (position-1));
			r.writeBytes("\r\n");
			r.writeBytes(str);
			r.writeBytes("\r\n");
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
	}

	//fix the length of string upto desirable length
	public String fixLength(String str, int lgt) {
		return (str + "                                   ").substring(0, lgt);
	}
}

/**********************************************

Workshop #3

Course:JAC444 - Semester - 4

Last Name:Singh

First Name:Gurpreet 

ID:145795167


This assignment represents my own work in accordance with Seneca Academic Policy.

Signature Gurpreet Singh

Date:12 JULY, 2018

**********************************************/




package workshop3;

import java.util.Arrays;
import java.util.List;

public class A_lambda {

	public static void main(String[] args) {

		List<String> topNames2017 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack",
				"Charlie", "harry", "Jacob");

		// lambda function for sorting the list
		topNames2017.sort((String x, String y) -> (x.substring(0, 1).toUpperCase() + x.substring(1))
				.compareTo(y.substring(0, 1).toUpperCase() + y.substring(1)));

		//converting the first character into upper case
		for (int i = 0; i < topNames2017.size(); i++) {
			topNames2017.set(i,
					topNames2017.get(i).substring(0, 1).toUpperCase() + topNames2017.get(i).substring(1).toLowerCase());
		}

		for (String z : topNames2017) {
			System.out.println(z);
		}

	}

}

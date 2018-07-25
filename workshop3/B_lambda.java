


package workshop3;

import java.util.Arrays;
import java.util.List;

public class B_lambda {

	public static void main(String[] args) {

		List<String> topNames2017 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack",
				"Charlie", "harry", "Jacob");
		//lambda function to sort the array
		topNames2017.sort((String x, String y) -> (x.substring(0, 1).toUpperCase() + x.substring(1))
				.compareTo(y.substring(0, 1).toUpperCase() + y.substring(1)));
		
		//converting the first character into upper case
		for (int i = 0; i < topNames2017.size(); i++) {
			topNames2017.set(i, topNames2017.get(i).substring(0, 1).toUpperCase() + topNames2017.get(i).substring(1));
		}

		/* using method reference
		 class name:: meathod_name*/
		topNames2017.forEach(System.out::println);

	}
}

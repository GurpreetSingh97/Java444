



package workshop3;

import java.util.Arrays;
import java.util.List;

public class C_lambda {

	public static void main(String[] args) {
		List<String> topNames2017 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack",
				"Charlie", "harry", "Jacob");

		//converting it into a stream and using chain of stream operations
		topNames2017.stream().map(s -> s.substring(0, 1).toUpperCase() + s.substring(1)).sorted()
				.forEach(System.out::println);

	}
}

package example2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommonItemFilterList {

	public static void main(String[] args) {

		List<String> masterList = Arrays.asList("rakesh", "sahu", "swati", "sahu");
		List<String> secondryList = Arrays.asList("swati");

		List<String> commonList = masterList.stream().filter(e -> (Collections.frequency(secondryList, e)) >= 1)
				                              .collect(Collectors.toList());

		commonList.forEach(System.out::println);
	}

}

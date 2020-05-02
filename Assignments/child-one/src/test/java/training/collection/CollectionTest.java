package training.collection;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

public class CollectionTest {

	public static void main(String[] args) {
		System.out.println("hello World");
		List<String> list = Arrays.asList("one", "two", "three");
		if(CollectionUtils.isNotEmpty(list)) {
			list.stream().forEach(System.out::println);
			
		} else {
			System.out.println("Empty Records");
		}
		;
		

	}

}

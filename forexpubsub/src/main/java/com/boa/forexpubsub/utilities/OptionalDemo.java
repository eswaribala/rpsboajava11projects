package com.boa.forexpubsub.utilities;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<String> nameOptional = Optional.of("Rishi");

		Stream<String> nameOptionalStream = nameOptional.stream();

		nameOptionalStream.forEach(System.out::println);
		Optional<String> name = Optional.of("Divya");
		name.ifPresentOrElse(x -> System.out.println("Hello " + x),
		        () -> System.out.println("Hello Guest"));
		name = Optional.empty();
		name.ifPresent(x->System.out.println(x));
		name.ifPresentOrElse(x -> System.out.println("Hello " + x),
		        () -> System.out.println("Hello Guest"));
		
		
		List<Optional<String>> listOption = Arrays.asList(
		        Optional.of("Sachin"), Optional.of("Sehwag"),
		        Optional.empty(), Optional.of("Dravid"));
		
		List<String> list = listOption.stream()
		        .flatMap(Optional::stream)
		        .collect(Collectors.toList());
		
		name = Optional.empty();
		//name.orElse("Guest!!!");
		//name.orElseGet(() -> {
		//    System.out.println("Returning the default value");
		//    return "Guest";
	//	});
		Optional<String> value = name.or(() -> Optional.of("Guest"));
		System.out.println(value);
		
	}

}

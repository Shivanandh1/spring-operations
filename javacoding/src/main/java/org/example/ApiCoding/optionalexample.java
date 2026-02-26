package org.example.ApiCoding;

import java.util.Optional;

public class optionalexample {

    public static void main(String[] args) {


        Optional<String> optional = Optional.of("hello");
        Optional<String> optional2 = Optional.ofNullable(null);
        Optional<String> optional3 = Optional.empty();

        System.out.println("value present"+optional.isPresent());
            optional.ifPresent(System.out::println);

            String result1= optional.orElse("default value");


    }
}

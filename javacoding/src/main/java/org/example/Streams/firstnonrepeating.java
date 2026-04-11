package org.example.Streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class firstnonrepeating {

    public static void main(String[] args) {
        String word="swiss";

        System.out.println(nonrepeatingcharacter(word));
    }

    private static Character nonrepeatingcharacter(String word) {

       return word.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(n -> n.getValue()==1).map(Map.Entry::getKey).findFirst().orElse(null);



    }


}

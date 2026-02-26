package org.example.ApiCoding;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class uppercase {
    public static void main(String[] args) {

         uppercasenew(List.of("tomoroow is relase of bahubali", "thursday"));
    }

    private static void uppercasenew(List<String> tomoroowIsRelaseOfBahubali) {

                 List<String> resultuppercase=tomoroowIsRelaseOfBahubali.stream().map(String::toUpperCase)
                         .toList();
        System.out.println(resultuppercase);

        List<String> letters= Arrays.asList("AA","BB","AA","CC","DD","CC");
//counting the elements in the list
        Map<String,Long> counttheelements= letters.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(counttheelements);
        //findng how many items which have duplicates

        Map<String ,Long> findduplicate=letters.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m->m.getValue()>1)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        System.out.println(findduplicate);

// maximum element in an array
            int[] arr={1,2,3,77};
            int maximumelement=Arrays.stream(arr).max().getAsInt();
        System.out.println(maximumelement);
        //counting each character in a string
         String s="risk reward its always me";
         Map<String,Long> charactercount=Arrays.stream(s.split("")).map(String::toLowerCase)
                 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(charactercount);


    }


}

package org.example.javapractice;

import java.util.*;
import java.util.stream.Collectors;

public class sortbyvalues {

    public static void main(String[] args) {

        System.out.println(sortedbyvalues(new HashMap<>(Map.of("A",3,"B",1,"C",2) )));
    }

    private static Map<String,Integer> sortedbyvalues(Map<String,Integer> input) {

        return input.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2)->e1,
                        LinkedHashMap::new
                ));

//
//                for(Map.Entry<String,Integer> iteration:input.entrySet()){
//
//                      int keys=iteration.getValue();
//                    List<Integer> values = List.of();
//                    values.add(keys);
//                    Collections.sort(values);
//                    Collections.reverse(values);
//
//                }

    }

}

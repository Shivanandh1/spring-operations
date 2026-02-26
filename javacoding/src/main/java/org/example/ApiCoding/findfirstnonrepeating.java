package org.example.ApiCoding;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class findfirstnonrepeating {

    public static void main(String[] args) {
        String input="y address is hyderabad";

        String s= String.valueOf(input.chars().
                mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()==1)
                .map(map->map.getKey())
                .findFirst()
                .orElse(null));
        System.out.println(s);

    }
}

package org.example.javapractice;

import java.util.*;
import java.util.stream.Collectors;

public class streamclass {

    public static void main(String[] args) {

        List<Integer> list=List.of(0,2,3,5,5,0,5,3,6,5,5);

        System.out.println(list.stream().distinct().toList());
        System.out.println(list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()))
                .entrySet().stream().filter(n->n.getValue()>1)
                .map(Map.Entry::getKey).collect(Collectors.toSet()));

        String str="programming";

        System.out.println(str.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(n->n, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(n->n.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null));

//        -------------------------------------------------------------------
        System.out.println(list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting())).entrySet().stream().filter(n->n.getValue()>1).findFirst().map(Map.Entry::getKey).orElse(null));

        //System.out.println(Collections.rotate(list,2));

        System.out.println(list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting())).entrySet()
                .stream().filter(n->n.getValue()>list.size()/2).map(Map.Entry::getKey).findFirst().orElse(null));

        System.out.println(list.stream().sorted(Comparator.reverseOrder()).toList());

        String s1="listen";
        String s2="silent";

        boolean anagram=s1.length()==s2.length()&& s1.chars().sorted().boxed().toList().equals(s2.chars().sorted().boxed().toList());

        System.out.println(anagram);
             String reverse="java is powerful";

//        System.out.println(reverse.chars().collect(Collections.reverse(reverse)));
    }
}

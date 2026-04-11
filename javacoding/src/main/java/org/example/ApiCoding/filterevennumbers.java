package org.example.ApiCoding;

import java.util.*;
import java.util.stream.Collectors;

public class filterevennumbers {

    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(2,34,45,12,3,4,4,3,2);
        List<Integer> evenNumbers=numbers.stream().filter(n->n%2==0).distinct().toList();
        System.out.println(evenNumbers);

             numbers.stream().filter(n->n%2==0).toList().forEach(System.out::println);
            // numbers.stream().filter(n-> n/n==1).toList().forEach(System.out::println);

             int[] arr={1,2,4,5,2,4};
             List<Integer> duplicates=Arrays.stream(arr).boxed().distinct().toList();
        System.out.println(duplicates+"wew");

        Optional<Integer> max=numbers.stream().max(Integer::compareTo);
        System.out.println(max);

        Optional<Integer> maximumnumber=numbers.stream().max(Integer::compare);
        System.out.println(maximumnumber);

        List<Integer> sortedList=numbers.stream().sorted().distinct().toList();
        System.out.println(sortedList);

        int sum=numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        int totalsum=numbers.stream().reduce(0,Integer::sum);
        System.out.println(totalsum+":totalsum");

        List<String> letters=Arrays.asList("tesla","alice","wonderland","assets");
        System.out.println(letters.stream().collect(Collectors.groupingBy(String::length)).entrySet().stream().max(Map.Entry.comparingByKey()).get().getValue()+"highh");
        List<String> uppercase=letters.stream().map(String::toUpperCase).toList();
        System.out.println(uppercase);

        List<String> firstnames=Arrays.asList("hoya busa","raja mouli","prabhas raj","white shirt");
        List<String> firstnamesfromarray=firstnames.stream().map(n->n.split(" ")[0]).toList();
        System.out.println(firstnamesfromarray);

        boolean positive=numbers.stream().noneMatch(n->n<0);
        System.out.println(positive);

            Optional<Integer> i=numbers.stream().findFirst();
        System.out.println(i);


        List<List<Integer>> flatmap=Arrays.asList(Arrays.asList(1,2,5),Arrays.asList(2,6,4));

        List<Integer> afterflatmap=flatmap.stream().flatMap(List::stream).toList();
        System.out.println(afterflatmap);


        List<Integer> reverseorder= numbers.stream().sorted(Collections.reverseOrder()).toList();
        System.out.println(reverseorder);

//        -------------------------------------------
            List<Integer> integers=Arrays.asList(12,11,24,46,75,15);
            integers.stream().map(s->s+"").filter(s->s.startsWith("1")).toList().forEach(System.out::println);
    }
}

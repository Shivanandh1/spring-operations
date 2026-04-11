package org.example.ApiCoding;

import java.util.*;
import java.util.stream.Stream;

public class duplicateLetter {
    public static void main(String[] args) {

     findduplicates("ineedtoinvolvebetalkative");
     concatstring();
        }

    private static void findduplicates(String s) {
        HashMap<Character,Integer> charcount=new HashMap<>();
            char[] chars=s.toCharArray();
            for(char chararray:chars){
            charcount.put(chararray,charcount.getOrDefault(chararray,0)+1);

            }

            for (Map.Entry<Character,Integer>map: charcount.entrySet()){
               if(map.getValue()>1){
                   System.out.println(map.getKey()+","+map.getValue());
               }

            }
    }

    private static void concatstring(){

        List<String> list1= Arrays.asList("2","23","3");
        List<String> list2= Arrays.asList("explained","individuality","confidence");
        Stream<String> concatstream=Stream.concat(list1.stream(),list2.stream());
        concatstream.forEach(str-> System.out.println(str+" "));
        //System.out.println(concatstream+"concatStream");

        //reverseorder
             list1.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

             List<Integer> list=Arrays.asList(2,3,5,6,4);
                        list.stream().map(i->i*i*i).filter(i->i>50).sorted().forEach(System.out::println);
       System.out.println("------");


    }
}


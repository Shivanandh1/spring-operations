package org.example;
import java.util.HashMap;
import java.util.Map;

public class CountWords {

    public static void main(String[] args) {
        
        countwords("saaaaaadgas afasdf asdg asdg asdg as");
    }
    private static void countwords(String input) {
        Map<String,Integer> map=new HashMap<>();

        String[] newword=input.split("\\s+");

        for(String word:newword){
               map.put(word, map.getOrDefault(word,0)+1);
        }
        System.out.println(map);
    }


}

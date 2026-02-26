package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("silent","listen"));
    }

    private static boolean isAnagram(String s, String s1) {

        Map<Character,Integer> freq=new LinkedHashMap<>();
        Map<Character,Integer> freq2=new LinkedHashMap<>();
        for(char charcterfreq:s.toCharArray()){
            freq.put(charcterfreq,freq.getOrDefault(charcterfreq,0)+1);
        }
        for(char charcterfreq1:s1.toCharArray()){
            freq2.put(charcterfreq1,freq2.getOrDefault(charcterfreq1,0)+1);
        }

        if(freq.equals(freq2)){
            return true;
        }
        return false;
    }
}

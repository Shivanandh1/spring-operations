package org.example.javapractice;

import java.util.LinkedHashMap;
import java.util.Map;

public class uniquestring {

    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("aaabbbbccc"));
    }
        public static int longestUniqueSubstring(String s) {

            Map<Character,Integer> unique=new LinkedHashMap<>();

            for(char c :s.toCharArray()){
                unique.put(c,unique.getOrDefault(c,0)+1);

            }
            int key = 0;
            key =unique.keySet().size();

            return key;
        }

}

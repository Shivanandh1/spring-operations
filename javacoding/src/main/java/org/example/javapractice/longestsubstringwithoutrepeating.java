package org.example.javapractice;

import java.util.HashSet;
import java.util.Set;

public class longestsubstringwithoutrepeating {
    public static void main(String[] args) {

        String word = "abcabcbb";

        Set<Character> set=new HashSet<>();
        int left=0; int max=0;
        for(int right=0; right<word.length()-1;right++ ){

            while(set.contains(word.charAt(right))){
                   set.remove(word.charAt(left++));
            }

            set.add(word.charAt(right));
            max=Math.max(max,right-left+1);
        }
        System.out.println(max);
    }
}

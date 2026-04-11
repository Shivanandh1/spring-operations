package org.example.javapractice;

import java.util.Collections;

public class palindrome {
    public static void main(String[] args) {
        String word="level";

        boolean palindrome=word.equals(new StringBuilder(word).reverse().toString());
        System.out.println(palindrome);

        int left=0;
        int right=word.length()-1;
        boolean palindromee=false;
        while(left<right){
            if(word.charAt(left)!=word.charAt(right)){
                 palindromee=false;
                break;
            }
            else {
                palindromee=true;
            }
            left++;
            right--;

        }
        System.out.println(palindromee);



    }
}

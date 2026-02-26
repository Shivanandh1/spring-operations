package org.example.javapractice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class Balancedparanthesis {

    public static void main(String[] args) {
        System.out.println(isBalanced("{{()}"));
    }

    public static boolean isBalanced(String input){
        Deque<Character> balance=new ArrayDeque<>();
        for(char character:input.toCharArray()) {
           if(character=='{' || character=='(') {
               balance.push(character);
           } else if (character=='}' || character==')') {
               if(balance.isEmpty()){
                   return false;
               }
               
           }
           char top=balance.pop();
            if((character==')' && top !='(') || (character=='{' && top!='}')){
                return true;
            }
        }
        return balance.isEmpty();
    }
}

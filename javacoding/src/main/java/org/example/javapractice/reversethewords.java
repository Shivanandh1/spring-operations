package org.example.javapractice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class reversethewords {
    public static void main(String[] args) {

        reversetheWords("java is powerful");
    }
    public static String reversetheWords(String string){

               int start=0;
             // String[] newstring=null;
               String[] newword= string.split("\\s");
                    int end=newword.length-1;

//              while(start<end){
//                  String temp=newword[start];
//                  newword[start]=newword[end];
//                  newword[end]=temp;
//                  start++;
//                  end--;
//
//              }
        List<String> newlist=Arrays.asList(newword);
        Collections.reverse(newlist);
        System.out.println(newlist);
               for(String s:newword ){
                   System.out.println(s);
               }
        return null;

    }
}

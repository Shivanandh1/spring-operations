package org.example.javapractice;

import java.util.Arrays;

public class movezeroes {

    public static void main(String[] args) {

        movezeroess(new int[]{0,1,0,3,10});
    }

    public static void movezeroess(int[] arr){
        if(arr==null || arr.length==0){
            return;
        }
        int index=0;
             for(int a:arr){
                 if(a!=0){
                     arr[index]=a;
                     index++;
                 }
             }
            while (index< arr.length){
                arr[index]=0;
                index++;
            }

        System.out.println(Arrays.toString(arr));
    }
}

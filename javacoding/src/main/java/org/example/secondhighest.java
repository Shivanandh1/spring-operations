package org.example;

public class secondhighest {
    public static void main(String[] args) {
        System.out.println(secondhighestnumber(new int[]{19, 23, 12, 11, 4, 5}));
    }

    private static int secondhighestnumber(int[] array) {

        int highest=Integer.MIN_VALUE;
        int secondhighest = Integer.MIN_VALUE;

        for(int num:array){
                if(num>highest){
                    secondhighest=highest;
                    highest=num;
                }
                if(num>secondhighest && num!=highest){
                    secondhighest=num;
                }
        }
     return secondhighest;
    }


}

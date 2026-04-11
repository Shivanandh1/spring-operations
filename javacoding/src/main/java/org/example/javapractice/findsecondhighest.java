package org.example.javapractice;

import java.util.Collections;
import java.util.List;

public class findsecondhighest {

    public static void main(String[] args) {

        List<Integer> arrayy=List.of(1, 3, 6, 7, 4, 5);

            int first=Integer.MIN_VALUE;
            int second=Integer.MIN_VALUE;

            for(int num:arrayy){
                if (num>first) {
                    first=num;
                    second=first;
                } else if (num>second&&num!=first) {
                    second=num;

                }
            }
        System.out.println("second higest"+second);

    }


}

package org.example.javapractice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FrequentInteger {

    public static void main(String[] args) {
        System.out.println(frequentmost(new int[]{1,2,3,1,1,2,2,2}));
    }
    public static Integer frequentmost(int[] arr){
        Map<Integer, Integer> countmap=new LinkedHashMap<>();
        for (int ch: arr){
                countmap.put(ch,countmap.getOrDefault(ch,0)+1);

        }
        Integer maxkey=null;
        int maxvalue=Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry:countmap.entrySet()){

                        if(entry.getValue()>maxvalue){
                            maxvalue=entry.getValue();
                            maxkey= entry.getKey();
                        }
        }
        return maxkey;
    }
}

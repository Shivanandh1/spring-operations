package org.example;

import java.util.Iterator;
import java.util.Map;

public class IterateHashMap {
    public static void main(String[] args) {

    }
    public void iterateHashMap(Map<String,String> map){
        for(Map.Entry<String,String> iterate:map.entrySet()){
            System.out.println(iterate.getKey()+","+iterate.getValue());
        }
        Iterator<Map.Entry<String,String>> iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry=iterator.next();
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}

package org.example.ApiCoding;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class concurrentexample {
    public static void main(String[] args) {

        Map<String,Integer> concurrentHashMap=new ConcurrentHashMap<>();

        concurrentHashMap.put("key1",2);
        //concurrentHashMap.putIfAbsent("key2",4);
        concurrentHashMap.computeIfAbsent("key3",k->4);

        concurrentHashMap.compute("key2",(key,value)->value==null?1:value+1);
        System.out.println("concurrent hashmap"+concurrentHashMap);
    }
}

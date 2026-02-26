package org.example;


import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChracter {

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("abacabad"));
    }
    public static Character firstNonRepeatingCharacter(String input) {
            if(input==null || input.isEmpty()){
                return null;
            }

        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
            for(char character:input.toCharArray()){
                charCountMap.put(character,charCountMap.getOrDefault(character,0)+1);
            }
            for(Map.Entry<Character,Integer> character:charCountMap.entrySet() ){
               if(character.getValue()==1){
                   return character.getKey();
               }

            }
        return null;
    }
    }

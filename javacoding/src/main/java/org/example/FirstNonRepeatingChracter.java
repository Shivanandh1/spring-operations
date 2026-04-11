package org.example;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChracter {

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("beachhead"));
        System.out.println(firstNonRepeatingCharacter1("swiss"));
    }

    private static Character firstNonRepeatingCharacter1(String beachhead) {

        Character repated=beachhead.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(n->n.getValue()==1).map(Map.Entry::getKey).findFirst().orElse(null);

        return repated;
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

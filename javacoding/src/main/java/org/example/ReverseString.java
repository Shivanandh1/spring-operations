package org.example;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reversestring("1234"));
    }
        public static String reversestring(String input){
                char[] chars=input.toCharArray();
                int left=0;
                int right=chars.length-1;

                if(left<right){
                    char temp= chars[left];
                    chars[left]=chars[right];
                    chars[right]=temp;
                    left++;
                    right--;
                }
            return new String(chars);
        }
}

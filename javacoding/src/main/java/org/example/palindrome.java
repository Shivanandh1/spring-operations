package org.example;

public class palindrome {

    public static void main(String[] args) {
      palindrome a=new palindrome();
        System.out.println(a.palindromecalc("101"));
        System.out.println(a.fibonocci(10));
    }

    public int fibonocci(int i) {
        if(i<=1) return i;
        return fibonocci(i-1)+fibonocci(i-2);
    }

    public boolean palindromecalc(String i) {
        int left=0,right=i.length()-1;
        while(left<right){
            if(i.charAt(left)!=i.charAt(right)){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

}

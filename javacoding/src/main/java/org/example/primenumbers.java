package org.example;

public class primenumbers {

    public static void main(String[] args) {

        if(prime(11)){
            System.out.println("prime");;
        }
        else{
            System.out.println("not prime");
        }
    }

    public static boolean prime(int a) {
      if(a<=1){
          return false;
      }
      for(int i=2;i<a;i++){
            if(a%i==0 ){
                return false;
            }
            return true;
        }
        return false;
    }
}

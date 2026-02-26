package org.example.ApiCoding;

@FunctionalInterface
public interface calculator {

    int calculate(int a,int b);

    default void display(){
        System.out.println("displaying the functional interface");
    }

}
class calculation {
    public static void main(String[] args) {
    calculator cal = Integer::sum;
    calculator cal1=(a,b)->a*b;

    System.out.println(cal.calculate(3,5));
        System.out.println(cal1.calculate(5,6));
}
}

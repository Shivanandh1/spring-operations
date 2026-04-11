package org.example.javapractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class moreQuestions {

    public static void main(String[] args) {
        List<Employee> list;
        List<Integer> integers= Arrays.asList(3,4,5,50,54,57,58);

        System.out.println(integers.stream().filter(n->n > 50 && n%2==0).findFirst().orElse(null));
        System.out.println(integers.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(null));
        




    }
    class Employee {
        int id;
        String name;
        String dept;
        double salary;
    }

}

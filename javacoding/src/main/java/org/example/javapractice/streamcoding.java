package org.example.javapractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class streamcoding {

    public static void main(String[] args) {

        List<Employee>  employeeList=new ArrayList<>();

        System.out.println(employeeList.stream().filter(e-> "IT".equals(e.dept)).toList());

        employeeList.stream().filter(e-> e.salary>50000)
                .map(e->e.name).toList();

        employeeList.stream().max(Comparator.comparingDouble(e-> e.salary)).orElse(null);

        employeeList.stream().sorted(Comparator.comparingDouble((Employee e)->e.salary).reversed()).toList();

        employeeList.stream().collect(Collectors.groupingBy((Employee employee) -> employee.dept,Collectors.counting()));

        employeeList.stream().collect(Collectors.groupingBy(e->e.dept,Collectors.averagingDouble(e->e.salary)));

        employeeList.stream().anyMatch(e->"HR".equals(e.dept));


    }


    class Employee{
        int id;
        String name;
        String dept;
        double salary;
    }
}

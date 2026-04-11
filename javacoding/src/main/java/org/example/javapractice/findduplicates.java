package org.example.javapractice;

import java.util.*;
import java.util.stream.Collectors;

public class findduplicates {

    public static void main(String[] args) {

        List<Integer> nums = List.of(4, 7, 2, 7, 9, 1, 4, 10);
        List<String> names = List.of("java", "spring", "api", "java", "cloud");

        System.out.println(nums.stream().distinct().toList());
        System.out.println(nums.stream().mapToInt(Integer::intValue).sum());
        System.out.println(nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null));
        System.out.println(nums.stream().filter(n->n%2!=0).sorted().toList());
        System.out.println(names.stream().map(String::toUpperCase).toList());
        System.out.println(names.stream().filter(n->n.length()>4).toList());
        System.out.println(nums.stream().collect(Collectors.groupingBy(n->n,Collectors.counting())));
        System.out.println(nums.stream().allMatch(n->n>0));
        System.out.println(names.stream().max(Comparator.comparing(String::length)).orElse(null));

        List<Employee> employeeList = List.of();
        
        System.out.println(employeeList.stream().sorted(Comparator.comparing((Employee e)->e.salary).reversed())
                .limit(3).toList());
        employeeList.stream().filter(n->n.name.startsWith("A")).toList();
        employeeList.stream().filter(e->"IT".equals(e.dept)).mapToDouble(Employee::getSalary).sum();

        employeeList.stream().collect(Collectors.partitioningBy(e->e.salary > 50_000));
        employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.dept,Collectors.averagingDouble(value -> value.salary)))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
                .orElse(null);

        employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1)
                .findFirst().orElse(null);

        employeeList.stream().sorted(Comparator.comparing(Employee::getDept)
                .thenComparingDouble(Employee::getSalary).reversed()).toList();

        employeeList.stream().collect(Collectors.toMap(e->e.name,e->e.salary));

        Map<String, Integer> scores = Map.of(
                "A", 10,
                "B", 40,
                "C", 25,
                "D", 40
        );

        scores.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);

        scores.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).toList();

        scores.entrySet().stream().filter(n->n.getValue()>20).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        scores.entrySet().stream().map(e->e.getKey()+"="+e.getValue()).toList();

        scores.entrySet().stream().filter(n->n.getValue().equals(40)).map(Map.Entry::getKey).toList();

        scores.values().stream().mapToInt(Integer::intValue).sum();

        scores.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        names.stream().filter(Objects::nonNull).map(String::trim).toList();



    }
     class Employee {
        int id;

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public int getId() {
             return id;
         }

         public void setId(int id) {
             this.id = id;
         }

         public String getDept() {
             return dept;
         }

         public void setDept(String dept) {
             this.dept = dept;
         }

         public double getSalary() {
             return salary;
         }

         public void setSalary(double salary) {
             this.salary = salary;
         }

         String name;
        String dept;
        double salary;

         @Override
         public String toString() {
             return "Employee{" +
                     "id=" + id +
                     ", name='" + name + '\'' +
                     ", dept='" + dept + '\'' +
                     ", salary=" + salary +
                     '}';
         }
         public Employee(int id, String name, String dept, double salary) {
             this.id = id;
             this.name = name;
             this.dept = dept;
             this.salary = salary;
         }
     }

}

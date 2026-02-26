package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface FunInterface{
    void display();
}
public class lambdaExample {

    public static void main(String[] args) {

       FunInterface funInterface=()-> System.out.println("this is the functional interfcace");

       funInterface.display();

        //ArrayList<Integer> list=new ArrayList<>();
        List<Integer> arrayList=new ArrayList<>(Arrays.asList(2,3,4,6,10));
                  List<Integer> ls=arrayList.stream().filter(integer -> integer%2==0).toList();
        System.out.println(ls+"filterlist");

        List<Integer>  list=new ArrayList<>(Arrays.asList(23,24,25,26,27));

           List<Integer> listmap =list.stream().map(integer -> integer+2).toList();
        System.out.println(listmap+"listmap");

        List<Integer>  listsorted=Arrays.asList(27,24,23,26,22);
        List<Integer> listsort =  listsorted.stream().sorted().toList();

        List<String> filterandupper=Arrays.asList("shiva","sai","dhaarini");
        List<String> filter=  filterandupper.stream().filter(s-> s.length()==5).map(String::toUpperCase).collect(Collectors.toList());        System.out.println(listsort+"listsort");

        System.out.println(filter+"filter");

        new Thread(() -> System.out.println("thread running")).start();

          String[] names={"shiva","sai","dhaarini"};
            Arrays.stream(names).forEach(lambdaExample::print);

    }
        public static void print(String s){
            System.out.println(s);
        }

}

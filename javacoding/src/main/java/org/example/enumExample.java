package org.example;

public class enumExample {
    enum Status {
        success,failed,running,pending;
    }

    public static void main(String[]args){
        Status status=Status.failed;

        System.out.println(status);
        for(Status s:Status.values()){
            System.out.println(s);
        }
    }
}

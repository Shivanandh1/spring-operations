package org.example.ApiCoding;

public class threadextends extends Thread{

    public static void main(String[] args) {
        threadextends th=new threadextends();
         th.start();
    }
        @Override
    public void run(){
         for(int i=0;i<=5;i++){

             System.out.println(Thread.currentThread().getName()+":"+i);
             try{
                 Thread.sleep(500);

             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }

         }

    }

}

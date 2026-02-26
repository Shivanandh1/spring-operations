package org.example.ApiCoding;

import java.util.Random;

public class threadimplemets implements Runnable {
    public static void main(String[] args) {
        threadimplemets th = new threadimplemets();
        th.run();
        bankaccount bnk=new bankaccount();
        bnk.withdraw(200);
        tempreader te=new tempreader();
                    te.run();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class bankaccount {
        private int balance = 1000;

        public synchronized void withdraw(int amount){
            if(balance>=amount){
                System.out.println(Thread.currentThread().getName()+":"+amount);
                balance-=amount;
                System.out.println("remaining balance"+balance);

            }
            else{
                System.out.println("insufficient balance");
            }

        }

    }

   static class tempreader implements Runnable{
       private volatile double temparature=25.0;
        @Override
        public void run() {
                temparature=20+(Math.random())*20;
            System.out.println("system updated temparature"+String.format("%2f",temparature));
        }
    }
}

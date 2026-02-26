package org.example.ApiCoding;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class executorservice {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0;i<4;i++){

            final int taskid=i;
            executorService.execute(()-> System.out.println("task"+taskid+"Executed by"+
                    Thread.currentThread().getName()));
        }
        Future<Integer> future = executorService.submit(
                ()-> {
                    Thread.sleep(2000);
                    return 42;
                }
                );
        try{
            System.out.println("result"+future.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}

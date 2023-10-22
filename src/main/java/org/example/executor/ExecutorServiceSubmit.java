package org.example.executor;

import java.util.concurrent.*;

public class ExecutorServiceSubmit {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

//        Callable<Integer> callable1 = () -> {
//            System.out.println("Callable1 Start");
//            Thread.sleep(100L);
//            System.out.println("Callable1 Thread: " + Thread.currentThread().getName());
//            System.out.println("Callable1 End");
//            return 1;
//        };
//
//        Callable<Integer> callable2 = () -> {
//            System.out.println("Callable2 Start");
//            Thread.sleep(100L);
//            System.out.println("Callable2 Thread: " + Thread.currentThread().getName());
//            System.out.println("Callable2 End");
//            return 2;
//        };

        Future<Integer> result1 = executorService.submit(() -> {
            System.out.println("Callable1 Start");
            Thread.sleep(100L);
            System.out.println("Callable1 Thread: " + Thread.currentThread().getName());
            System.out.println("Callable1 End");
            return 1;
        });
        Future<Integer> result2 = executorService.submit(() -> {
            System.out.println("Callable2 Start");
            Thread.sleep(100L);
            System.out.println("Callable2 Thread: " + Thread.currentThread().getName());
            System.out.println("Callable2 End");
            return 2;
        });

        System.out.println("Non Blocking");

        System.out.println("result1 = " + result1.get());
        System.out.println("Blocking 1");

        System.out.println("result2 = " + result2.get());
        System.out.println("Blocking 2");

        executorService.shutdown();
    }

}

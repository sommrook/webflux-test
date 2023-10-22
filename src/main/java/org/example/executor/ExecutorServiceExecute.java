package org.example.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExecute {

    public static void main(String[] args) throws InterruptedException {
        /*
         * shutdown과 shutdownNow 시에 중요한 것은, 만약 실행중인 작업들에서 인터럽트 여부에 따른 처리 코드가 없다면, 계속 실행된다는 것이다.
         * 그러므로 필요하다면 다음과 같이 인터럽트시에 추가적인 조치를 구현해야 한다.
         *
         * Execute는 반환값이 없기 때문에 Future를 반환하지 않는다.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        final Runnable runnable1 = () -> {
//            System.out.println("Runnable1 Start");
//
//            while (true) {
//                if (Thread.currentThread().isInterrupted()){
//                    System.out.println("Interrupted");
//                    break;
//                }
//                System.out.println("Runnable1 Thread: " + Thread.currentThread().getName());
//            }
//            System.out.println("Runnable1 End");
//        };
//
//        Runnable runnable2 = () -> {
//            System.out.println("Runnable2 Start");
//
//            while (true) {
//                if (Thread.currentThread().isInterrupted()){
//                    System.out.println("Interrupted");
//                    break;
//                }
//                System.out.println("Runnable2 Thread: " + Thread.currentThread().getName());
//            }
//            System.out.println("Runnable2 End");
//        };

        executorService.execute(() -> {
            System.out.println("Runnable1 Start");

            while (true) {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("Interrupted");
                    break;
                }
//                System.out.println("Runnable1 Thread: " + Thread.currentThread().getName());
            }
            System.out.println("Runnable1 End");
        });
        executorService.execute(() -> {
            System.out.println("Runnable2 Start");

            while (true) {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("Interrupted");
                    break;
                }
//                System.out.println("Runnable2 Thread: " + Thread.currentThread().getName());
            }
            System.out.println("Runnable2 End");
        });

        System.out.println("Non Blocking");
        Thread.sleep(1000L);
        executorService.shutdownNow();
    }
}

package org.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThread {

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int cnt = 1;
            int multiple = 1;
            while (cnt <= 10) {
                multiple = multiple * cnt;
                System.out.println("*" + cnt + "=" + multiple);
                cnt++;
            }
            return multiple;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyCallable callable = new MyCallable();
        // 람다식 변환
        FutureTask futureTask = new FutureTask(() -> {
            int cnt = 1;
            int multiple = 1;
            while (cnt <= 10) {
                multiple = multiple * cnt;
                System.out.println("*" + cnt + "=" + multiple);
                cnt++;
            }
            return multiple;
        });
        // Thread 클래스는 Runnable을 인자로 받는다.
        // Callable Interface를 사용할 때엔 FutureTask를 한단계 더 거쳐서 인자로 넣어 주어야 한다.
        Thread thread = new Thread(futureTask);
        thread.start();

        int cnt = 1;
        int sum = 0;
        while (cnt <= 10){
            sum += cnt;
            System.out.println("+" +cnt + "=" + sum);
            cnt++;
        }

        System.out.println("result = " + futureTask.get());
    }
}

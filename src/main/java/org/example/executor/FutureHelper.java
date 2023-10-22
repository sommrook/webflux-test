package org.example.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureHelper {

    public static Future<Integer> getFuture() {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        var executor = Executors.newSingleThreadExecutor();

        try {
            // submit에 Callable Interface의 구현체(작업)이 들어감
            return executor.submit(() -> 1);
        } finally {
            executor.shutdown();
        }
    }

    public static Future<Integer> getFutureCompleteAfter1s() {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        var executor = Executors.newSingleThreadExecutor();

        try {
            return executor.submit(() ->{
                Thread.sleep(1000);
                return 1;
            });
        } finally {
            executor.shutdown();
        }
    }
}

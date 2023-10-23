package org.example.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

@Slf4j
public class RunAsyncExample {

    public static void run() throws InterruptedException, ExecutionException {
        var future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        assert !future.isDone();
        log.info("{}", !future.isDone());

        Thread.sleep(1000);
        assert future.isDone();
        log.info("{}", future.isDone());
        assert future.get() == null;
        log.info("{}", future.get() == null);

        var future2 = CompletableFuture.runAsync(() -> {
           log.info("future2 - runAsync");
        }).thenRunAsync(() -> {
            log.info("future2 - thenRunAsync");
        });

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        run();
    }
}

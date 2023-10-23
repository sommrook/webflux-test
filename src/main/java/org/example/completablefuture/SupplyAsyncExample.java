package org.example.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class SupplyAsyncExample {

    public static void supply() throws InterruptedException, ExecutionException {
        var future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        });
        // 아직 끝나지 않았다.
        log.info("{}", !future.isDone());

        Thread.sleep(1000);

        log.info("{}", future.isDone());
        log.info("{}", future.get() == 1);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        supply();
    }
}

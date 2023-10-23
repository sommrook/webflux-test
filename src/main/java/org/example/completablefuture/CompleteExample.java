package org.example.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class CompleteExample {

    public static void complete() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        log.info("{}", !future.isDone());

        var triggered = future.complete(1);
        log.info("{}", future.isDone());
        log.info("{}", triggered);
        log.info("{}", future.get()==1);

        triggered = future.complete(2);
        log.info("{}", future.isDone());
        log.info("{}", !triggered);
        log.info("{}", future.get() == 1);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        complete();
    }
}

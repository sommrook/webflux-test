package org.example.completionstage;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Slf4j
public class Helper {
    @SneakyThrows
    public static CompletionStage<Integer> finishedStage(){
        var future = CompletableFuture.supplyAsync(() -> {
            log.info("supplyAsync");
            return 1;
        });
        Thread.sleep(100);
        log.info("return in future");
        return future;
    }

    public static CompletionStage<Integer> runningStage() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                log.info("I'm running!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        });
    }

}

package org.example.completionstage;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Slf4j
public class ThenRunExample {

    public static void runAsync() throws InterruptedException {
        log.info("start main");
        CompletionStage<Integer> stage = Helper.finishedStage();
        stage.thenRunAsync(() -> {
            log.info("in thenRunAsync");
        }).thenRunAsync(() -> {
            log.info("in thenRunAsync2");
        }).thenAcceptAsync(value -> {
            log.info("{} in thenAcceptAsync", value);
        });

        Thread.sleep(100);
    }


    public static void main(String[] args) {
        try {
            runAsync();

        } catch(InterruptedException e){
           log.error(e.getMessage());
        }
    }
}

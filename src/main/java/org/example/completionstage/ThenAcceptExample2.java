package org.example.completionstage;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletionStage;

@Slf4j
public class ThenAcceptExample2 {

    public static void accept() throws InterruptedException {
        log.info("start main");
        CompletionStage<Integer> stage = Helper.runningStage();
        stage.thenAccept(i -> {
            log.info("{} in thenAccept", i);
        }).thenAccept(i -> {
            log.info("{} in thenAccept2", i);
        });

        Thread.sleep(2000);
    }

    public static void acceptAsync() throws InterruptedException {
        log.info("start main");
        CompletionStage<Integer> stage = Helper.runningStage();
        stage.thenAcceptAsync(i -> {
            log.info("{} in thenAcceptAsync", i);
        }).thenAcceptAsync(i -> {
            log.info("{} in thenAcceptAsync", i);
        });

        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        acceptAsync();
    }
}

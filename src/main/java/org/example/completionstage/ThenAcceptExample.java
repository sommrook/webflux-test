package org.example.completionstage;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletionStage;

@Slf4j
public class ThenAcceptExample {
    public static void accept() throws InterruptedException {
        log.info("start main");
        CompletionStage<Integer> stage = Helper.finishedStage();
        stage.thenAccept(i -> {
            log.info("{} in thenAccept", i);
        }).thenAccept(i -> {
            log.info("{} in thenAccept2", i);
        });
        log.info("after thenAccept");

        Thread.sleep(100);
    }

    public static void acceptAsync() throws InterruptedException {
        log.info("start main");
        CompletionStage<Integer> stage = Helper.finishedStage();
        stage.thenAcceptAsync(i -> {
            log.info("{} in thenAcceptAsync", i);
        }).thenAcceptAsync(i -> {
            log.info("{} in thenAcceptAsync2", i);
        });
        log.info("after thenAccept");

        Thread.sleep(100);
    }

    public static void main(String[] args) throws InterruptedException {
        accept();
    }

}

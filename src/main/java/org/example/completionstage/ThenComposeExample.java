package org.example.completionstage;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletionStage;

@Slf4j
public class ThenComposeExample {

    public static void composeAsync() throws InterruptedException {
        log.info("start main");
        CompletionStage<Integer> stage = Helper.finishedStage();
        stage.thenComposeAsync(value -> {
            var next = Helper.addOne(value);
            log.info("in thenComposeAsync: {}", next);
            return next;
        }).thenComposeAsync(value -> {
            var next = Helper.addOne(value);
            log.info("in thenComposeAsync2: {}", next);
            return next;
        }).thenAcceptAsync(value -> {
            log.info("{} in thenAcceptAsync", value);
        });

        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        composeAsync();
    }
}

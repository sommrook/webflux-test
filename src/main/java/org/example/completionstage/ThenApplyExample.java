package org.example.completionstage;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletionStage;

@Slf4j
public class ThenApplyExample {

    public static void applyAsync() throws InterruptedException {
        CompletionStage<Integer> stage = Helper.finishedStage();
        stage.thenApplyAsync(value -> {
            log.info("{}", value);
            var next = value + 1;
            return next;
        }).thenApplyAsync(value -> {
            log.info("{}", value);
            var next = "result: " + value;
            return next;
        }).thenApplyAsync(value -> {
            log.info("{}", value);
            var next = value.equals("result: 2");
            return next;
        }).thenAcceptAsync(value ->
                log.info("{}", value));

        Thread.sleep(100);
    }

    public static void main(String[] args) throws InterruptedException {
        applyAsync();
    }
}

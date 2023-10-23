package org.example.completionstage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionallyExample {

    public static void exceptionally() throws InterruptedException {
        Helper.finishedStage()
                .thenApplyAsync(i -> {
                    log.info("in thenApplyAsync");
                    return i / 0;
                }).exceptionally(e -> {
                    log.info("{} in exceptionally", e.getMessage());
                    return 0;
                }).thenAcceptAsync(value -> {
                    log.info("{} in thenAcceptAsync", value);
                });

        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        exceptionally();
    }
}

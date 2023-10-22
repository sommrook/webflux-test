package org.example.executor;

import org.example.executor.FutureHelper;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {

    public static void future_get1() throws ExecutionException, InterruptedException {
        Future<Integer> future = FutureHelper.getFuture();
        System.out.println(!future.isDone());
        System.out.println(!future.isCancelled());

        var result = future.get(); // Blocking
        System.out.println(result.equals(1));
        System.out.println(future.isDone());
        System.out.println(!future.isCancelled());
    }

    public static void future_get2() throws ExecutionException, InterruptedException, TimeoutException {
//        Future future = FutureHelper.getFutureCompleteAfter1s();
//        var result = future.get(1500, TimeUnit.MILLISECONDS);

        Future<Integer> futureToTimeout = FutureHelper.getFutureCompleteAfter1s();
        Exception exception = null;
        try {
            futureToTimeout.get(500, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            exception = e;
        }
        System.out.println("exception = " + exception);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        future_get2();
    }
}

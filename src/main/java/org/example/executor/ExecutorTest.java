package org.example.executor;

import java.util.concurrent.Executor;

public class ExecutorTest {

    static class RunExecutor implements Executor {
        @Override
        public void execute(final Runnable command) {
//            command.run();
            new Thread(command).start();
        }
    }

    public static void main(String[] args){
        // 함수형 인터페이스인 Runnable을 이용 해서 runnable을 Runnable 변수로 선언 한다.
        // 람다식 으로 표현 되어 있는 구문은 run 메소드의 내용 이다.
        final Runnable runnable = () -> System.out.println("Thread: " + Thread.currentThread().getName());

        Executor executor = new RunExecutor();
        executor.execute(runnable);
    }
}

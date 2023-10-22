package org.example.thread;

public class RunnableThread {

    static class MyRunnable implements Runnable {
        @Override
        public void run(){
            int cnt = 1;
            int multiple = 1;
            while (cnt <= 10) {
                multiple = multiple * cnt;
                System.out.println("*" + cnt + "=" + multiple);
                cnt++;
            }
        }
    }


    public static void main(String[] args){
//        Runnable r = new MyRunnable();
        // 람다식으로 변환할 수 있다.
        Thread t = new Thread(() -> {
            int cnt = 1;
            int multiple = 1;
            while (cnt <= 10) {
                multiple = multiple * cnt;
                System.out.println("*" + cnt + "=" + multiple);
                cnt++;
            }
        });
        t.start();

        int cnt = 1;
        int sum = 0;
        while (cnt <= 10){
            sum += cnt;
            System.out.println("+" +cnt + "=" + sum);
            cnt++;
        }
    }
}

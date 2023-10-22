package org.example.thread;

public class BasicThread {

    static class MyThread extends Thread{
        @Override
        public void run() {
            int cnt = 1;
            int multiple = 1;
            while (cnt <= 10) {
                multiple = multiple * cnt;
                System.out.println("*" + cnt + "=" + multiple);
                cnt++;
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();
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

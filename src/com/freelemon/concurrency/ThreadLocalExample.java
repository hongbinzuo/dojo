package com.freelemon.concurrency;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-11-8
 * Time: 下午12:24
 * To change this template use File | Settings | File Templates.
 */
public class ThreadLocalExample {


    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();

        @Override
        public void run() {
            int myValue = (int) (Math.random() * 100D);
            System.out.println(Thread.currentThread().getName() + ": my value is set:"+ myValue);

            threadLocal.set(myValue);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName() + ": my value is:"+ threadLocal.get());
        }
    }


    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();
    }

}

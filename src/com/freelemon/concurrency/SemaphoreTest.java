package com.freelemon.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/5/14
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class SemaphoreTest {

    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semp = new Semaphore(5);

        for (int i=0;i<10;i++){
            final int num = i;

            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try{
                        semp.acquire();
                        System.out.println("Thread "+Thread.currentThread().getName() +
                                " acquired permission:" + num);
                        for (int j=0;j<999999;j++);

                        semp.release();
                        System.out.println("Thread "+Thread.currentThread().getName() +
                                " released permission:" + num);

                        System.out.println("currently permitted :" + semp.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            };

            exec.execute(run);
        }

        exec.shutdown();

    }
}

package com.freelemon.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/5/14
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestHarness {
    public long timerTasks(int nThreads, final Runnable task) throws InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i=0;i<nThreads;i++){
            Thread t = new Thread(){
                public void run(){
                    try{
                        startGate.await();
                        try
                        {
                            task.run();
                        }finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            };

            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end -start;

    }
}

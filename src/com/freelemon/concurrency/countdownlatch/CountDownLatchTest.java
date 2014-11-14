package com.freelemon.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-11-14
 * Time: 下午10:04
 * To change this template use File | Settings | File Templates.
 */
class Worker implements Runnable  {
    private int id;
    private CountDownLatch beginSignal;
    private CountDownLatch endSignal;

    public Worker(int id, CountDownLatch begin, CountDownLatch end){
        this.id = id;
        this.beginSignal = begin;
        this.endSignal = end;
    }

    @Override
    public void run() {
        try {
            beginSignal.await();
            System.out.println("Ready to run...");

            SECONDS.sleep(2);
            System.out.println("Worker" + id + " arrived.");

            endSignal.countDown();

            System.out.println("Worker" + id + " do other things.");

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}


public class CountDownLatchTest{
    public static void main(String[] args){
        CountDownLatch beginSingal = new CountDownLatch(1);
        CountDownLatch endSingal = new CountDownLatch(8);

        for(int i=0;i<8;i++){
            new Thread(new Worker(i, beginSingal, endSingal)).start();
        }

        try {

            // count down, then every waiting thread going to do real thing(here is sleep(2) )
            beginSingal.countDown();

            // wait all threads finish their countDown, then it passes through await...
            endSingal.await();
            System.out.println("Result is being reported to system.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
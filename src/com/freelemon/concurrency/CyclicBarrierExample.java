package com.freelemon.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/6/14
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class CyclicBarrierExample {
    public static class Task implements Runnable{
        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName() + " is waiting on the barrier.");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier.");
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (BrokenBarrierException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public static void main(String[] args){
        final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("all parties arrived, let's play!");
            }
        });

        new Thread(new Task(cb), "Thread 1").start();
        new Thread(new Task(cb), "Thread 2").start();
        new Thread(new Task(cb), "Thread 3").start();

    }

}

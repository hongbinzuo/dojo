package com.freelemon.concurrency.chp13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-11-15
 * Time: 上午11:41
 * To change this template use File | Settings | File Templates.
 */
public class ReentrantLockingDemo {
    private final Lock lock = new ReentrantLock();

    public static void main(final String... args){
        new ReentrantLockingDemo().go();
    }

    private void go(){
        new Thread(newRunnable(), "Thread-1").start();
        new Thread(newRunnable(), "Thread-2").start();
    }

    private Runnable newRunnable(){
        return new Runnable(){

            @Override
            public void run() {
                do{
                    try{
                        if (lock.tryLock(500, TimeUnit.MILLISECONDS)){
                            try{
                                System.out.println("Locked thread " + Thread.currentThread().getName());
                                Thread.sleep(1000);
                            } finally {
                                lock.unlock();
                                    System.out.println("unlocked locked thread " + Thread.currentThread().getName());
                            }
                            break;
                        } else {
                            System.out.println("unable to lock thread " + Thread.currentThread().getName() + ", will try again.");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                } while(true);
            }
        };
    }
}

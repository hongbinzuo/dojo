package com.freelemon.concurrency.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SeqPrinter2 {
    private Lock lock = new ReentrantLock();
    private Condition thread1Ready = lock.newCondition();
    private Condition thread2Ready = lock.newCondition();

    public static void main(String[] args){
        SeqPrinter2 printer2 = new SeqPrinter2();
        printer2.printSequence();
    }

    public void printSequence(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();

                    thread1Ready.await();

                    System.out.println(1);

                    thread2Ready.signal();
                    thread1Ready.await();


                    System.out.println(3);

                    thread2Ready.signal();
                    thread1Ready.await();


                    System.out.println(5);

                    thread2Ready.signal();
                    thread1Ready.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }


            }
        }, "Thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();

                    thread1Ready.signal();
                    thread2Ready.await();

                    System.out.println(2);

                    thread1Ready.signal();
                    thread2Ready.await();

                    System.out.println(4);

                    thread1Ready.signal();
                    thread2Ready.await();

                    System.out.println(6);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }


            }
        }, "Thread-2").start();

    }


}

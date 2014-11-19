package com.freelemon.concurrency.threads;

import java.io.Serializable;

public class SeqPrinter1 {
    private Object obj = new Object();
    private boolean isThread1 = true;

    public static void main(String[] args){
        SeqPrinter1 printer1 = new SeqPrinter1();
        printer1.printSequence();
        Serializable s= null;
    }

    public void printSequence() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println(1);
                    isThread1 = false;
                    obj.notify();

                    while (!isThread1){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(3);
                    isThread1 = false;
                    obj.notify();

                    while (!isThread1){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(5);
                    isThread1 = false;
                    obj.notify();

                }
            }
        }, "Thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    while (isThread1){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(2);
                    isThread1 = true;
                    obj.notify();

                    while (isThread1){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(4);
                    isThread1 = true;
                    obj.notify();

                    while (isThread1){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(6);
                    isThread1 = true;
                    obj.notify();

                }
            }
        }, "Thread-2").start();

    }

}

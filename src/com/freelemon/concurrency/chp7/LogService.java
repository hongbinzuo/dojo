package com.freelemon.concurrency.chp7;

import java.io.PrintWriter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/7/14
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class LogService {
    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter writer;
    private boolean isShutdown;
    private int reservations;

    public LogService(){
        this.queue = new ArrayBlockingQueue<String>(100);
        this.loggerThread = new LoggerThread();
        writer = new PrintWriter(System.out);
    }

    public void start(){
        loggerThread.start();
    }

    public void stop(){
        synchronized (this) {
            isShutdown = true;
        }

        loggerThread.interrupt();
    }

    public void log(String msg) throws InterruptedException{
        synchronized (this){
            if (isShutdown)
                throw new IllegalStateException("...");
            ++ reservations;
        }

        queue.put(msg);
    }


    private class LoggerThread extends Thread {
        public void run(){
            try{
                while(true){
                    try{
                        synchronized (LogService.this){
                            if (isShutdown && reservations==0)
                                break;
                        }

                        String msg = queue.take();
                        synchronized (LogService.this){
                            --reservations;
                        }

                        writer.println(msg);
                    } catch (InterruptedException e) {
                        /* retry */
                    }
                }
            } finally {
                writer.close();
            }
        }
    }

}


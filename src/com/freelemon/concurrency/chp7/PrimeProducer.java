package com.freelemon.concurrency.chp7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/7/14
 * Time: 5:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    PrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    public void run() {
        BigInteger p = BigInteger.ONE;

        while(!Thread.currentThread().isInterrupted()){
            try {
                queue.put( p =  p.nextProbablePrime());
            } catch (InterruptedException e) {
                System.out.println("I am gonna quit");
                //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public void cancel(){
        interrupt();
    }

    public static void main(String[] args) {
        BlockingQueue<BigInteger> queue1 = new ArrayBlockingQueue<BigInteger>(10);
        PrimeProducer producer = new PrimeProducer(queue1);
        producer.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        producer.cancel();

    }
}

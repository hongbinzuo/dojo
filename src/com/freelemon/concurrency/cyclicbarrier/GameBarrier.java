package com.freelemon.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-11-14
 * Time: 下午10:22
 * To change this template use File | Settings | File Templates.
 */
public class GameBarrier {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable(){

            @Override
            public void run() {

                System.out.println("All players enter into second guan.");
            }
        });

        for (int i = 0; i < 4; i++) {
            new Thread(new Player(i, cyclicBarrier)).start();
        }

    }
}

class Player implements Runnable{
    private CyclicBarrier cyclicBarrier;
    private int id;

    public Player(int id, CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
    }


    @Override
    public void run() {

        try {
            System.out.println("Player "+ id + " is now playing the first guan.");
            TimeUnit.SECONDS.sleep(2);

            cyclicBarrier.await();
            System.out.println("Player "+ id + " is now playing the second guan.");

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (BrokenBarrierException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}

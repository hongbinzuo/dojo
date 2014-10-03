package com.freelemon;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/30/14
 * Time: 8:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsingExecutor {
    public static void main(String[] args){
        final Executor executor = Executors.newCachedThreadPool();
        executor.execute(new Thread(){
            public void run(){
                System.out.println("Test executor 1....");
            }
        });

        executor.execute(new Thread(){
            public void run(){
                System.out.println("Test executor 2....");
            }
        });

        executor.execute(new Thread(){
            public void run(){
                System.out.println("Test executor 3....");
            }
        });
    }
}

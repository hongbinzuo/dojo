package com.freelemon.concurrency.chp6;

import java.util.concurrent.Executor;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/6/14
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable r){
        new Thread(r).start();
    }
}

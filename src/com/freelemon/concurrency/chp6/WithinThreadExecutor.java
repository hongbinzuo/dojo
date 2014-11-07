package com.freelemon.concurrency.chp6;

import java.util.concurrent.Executor;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/6/14
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class WithinThreadExecutor implements Executor {
    public void execute(Runnable r){
        r.run();
    }
}

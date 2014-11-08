package com.freelemon.concurrency.chp7;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/7/14
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimedRun {
    // this example is not complete
    // refer to my blog
    public static void timedRun(Runnable r, long timeout, TimeUnit unit)
        throws InterruptedException{

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> task = executorService.submit(r);

        try {
            task.get(timeout, unit);
        } catch (ExecutionException e) {
            //
        } catch (TimeoutException e) {
            //throw e;
        }  finally {
            task.cancel(true);
        }


    }
}

package com.freelemon.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/5/14
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class FutureTest {

    public static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            String tid = String.valueOf(Thread.currentThread().getId());
            System.out.printf("Thread#%s: in call\n", tid);

            return tid;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newCachedThreadPool();

        for (int i=0;i<100;i++){
            results.add(es.submit(new Task()));
        }

        for(Future<String> res: results){
            System.out.println(res.get());
        }
    }

    public static void testFutureTask(){
        // FutureTask
    }
}

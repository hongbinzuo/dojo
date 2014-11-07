package com.freelemon.concurrency.chp6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/6/14
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class LifeCycleWebServer {
    private final ExecutorService es = Executors.newFixedThreadPool(20);

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);

        while (!es.isShutdown()){
            try{
                final Socket conn = socket.accept();
                es.execute(new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(conn);
                    }
                });
            } catch (RejectedExecutionException e){
                if (!es.isShutdown()){
                    // print log
                }
            }
        }

    }

    public void stop(){
        es.shutdown();
    }


    private void handleRequest(Socket conn) {
        //To change body of created methods use File | Settings | File Templates.
        // placeholder
//        Request req = readRequest(conn);
//
//        if (isShutdownRequest(req)){
//            stop();
//        } else {
//            dispatchRequest(req);
//        }
    }


}

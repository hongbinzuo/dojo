package com.freelemon.designpatterns;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/29/14
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoggingClient {
    private final Logging logging;

    public LoggingClient(Logging logging){
        this.logging = logging;
    }

    public void doWork(final int count){
        if ( count % 2 == 0 ){
            logging.write("Even number: " + count);
        }
    }


}

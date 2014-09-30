package com.freelemon.designpatterns.strategy;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/29/14
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleLogging implements Logging {
    @Override
    public void write(final String message){
        System.out.println("Logging here now...");
    }

}

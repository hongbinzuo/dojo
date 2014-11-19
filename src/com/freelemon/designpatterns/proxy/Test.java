package com.freelemon.designpatterns.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/19/14
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String... args){
        Subject subject = new ProxySubject();

        subject.request();
    }
}

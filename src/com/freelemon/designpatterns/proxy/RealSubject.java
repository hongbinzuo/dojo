package com.freelemon.designpatterns.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/19/14
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class RealSubject extends Subject {
    public RealSubject(){}

    @Override
    public void request() {
        System.out.println("From real subject..");
    }
}

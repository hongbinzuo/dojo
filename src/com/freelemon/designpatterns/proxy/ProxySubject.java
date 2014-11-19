package com.freelemon.designpatterns.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/19/14
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProxySubject extends Subject {
    private RealSubject realSubject;

    public ProxySubject(){

    }

    @Override
    public void request() {
        preRequest();

        if ( realSubject == null ){
            realSubject = new RealSubject();
        }

        realSubject.request();

        postRequest();
    }

    private void preRequest(){
        System.out.println("Pre- Request");
    }

    private void postRequest(){
        System.out.println("Post- Request");
    }
}

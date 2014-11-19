package com.freelemon.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/19/14
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class VectorProxy implements InvocationHandler {
    private Object proxyObj;

    public VectorProxy(Object object){
        proxyObj = object;
    }

    public static Object factory(Object o){
        Class cls = o.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new VectorProxy(o));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //return null;
        System.out.println("Before calling " + method);

        if ( args!= null){
            for (int i = 0; i < args.length ; i++) {
                System.out.println(args[i]+ " ");
            }
        }

        Object o = method.invoke(proxyObj, args);
        System.out.println("After calling " + method);

        return o;
    }

    public static void main(String[] args){
        List v = null;
        v = (List) factory(new Vector(10));
        v.add("New");
        v.add("York");
    }
}

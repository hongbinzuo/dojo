package com.freelemon.concurrency.cache;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/6/14
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}

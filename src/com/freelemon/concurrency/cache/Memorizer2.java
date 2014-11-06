package com.freelemon.concurrency.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/6/14
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Memorizer2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memorizer2(Computable<A, V> c){
        this.c = c;
    }


    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);

        if ( result == null ){
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return  result;
    }
}

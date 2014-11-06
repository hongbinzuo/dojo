package com.freelemon.concurrency.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/6/14
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Memorizer1<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);

        if ( result == null ){
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return  result;
    }

    public Memorizer1(Computable<A, V> c){
        this.c = c;
    }


}

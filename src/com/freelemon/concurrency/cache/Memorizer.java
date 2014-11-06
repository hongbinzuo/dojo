package com.freelemon.concurrency.cache;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/6/14
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class Memorizer<A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memorizer(Computable<A, V> c){
        this.c = c;
    }

    public V compute(final A arg) throws InterruptedException {
        while (true){
            Future<V> f = cache.get(arg);

            if ( f == null ){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };

                FutureTask<V> ft = new FutureTask<V>(eval);
                f = cache.putIfAbsent(arg, ft);
                if ( f == null ) {
                    f=ft;
                    ft.run();
                }
            }

            try {
                return f.get();
            } catch (CancellationException e){
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }


        }
    }


}

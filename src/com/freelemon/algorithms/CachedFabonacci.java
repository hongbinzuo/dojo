package com.freelemon.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/30/14
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class CachedFabonacci {
    @Test
    public void testCachedFibo(){
        System.out.println(System.currentTimeMillis());
        cacheFibo(1118);
        System.out.println(System.currentTimeMillis());

        cacheFibo(1186);

        System.out.println(System.currentTimeMillis());
    }


    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int cacheFibo(int m){
        if ( cache.containsKey(m)){
            return (Integer)cache.get(m);
        }

        if(m == 0) {
            cache.put(0, 0);
            return 0;
        } else if (m==1){
            cache.put(1, 1);
            return 1;
        } else {
            cache.put(m, cacheFibo(m - 1)+ cacheFibo(m-2));
            return cacheFibo(m);
        }

    }
}

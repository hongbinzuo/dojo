package com.freelemon.designpatterns.strategy;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/30/14
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class FibonacciNth {
    @Test
    public void testGetFibonacci(){
        assertEquals(getFibonacci(6), 8);
    }

    public static int getFibonacci(int n){
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 1;
        return getFibonacci(n-1)+ getFibonacci(n-2);

    }
}

package com.freelemon;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/30/14
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Factorial {
    @Test
    public void testFactorial(){
        assertEquals(6, factorial(3));
        assertEquals(24, factorial(4));
        assertEquals(120, factorial(5));
    }


    public int factorial(int n){
        if ( n < 1 )
            throw new IllegalArgumentException("n must be greater than 0");


        int result = 1;
        for(int i=1;i<=n;i++){
            result *= i;
        }

        return result;
    }


}

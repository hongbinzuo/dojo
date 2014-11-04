package com.freelemon.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/30/14
 * Time: 1:35 PM
 * Same as original version, just another practice.
 */
public class FibonacciNew {
    @Test
    public void testFibonacci(){
        List<Integer> r = new ArrayList<>();
        r.add(0);
        r.add(1);
        r.add(1);
        r.add(2);
        r.add(3);
        r.add(5);
        r.add(8);
        r.add(13);
        assertEquals(r, produceFibonacci(8));
    }


    public static List<Integer> produceFibonacci(int n){
        if ( n < 0 ){
            throw  new IllegalArgumentException("n cannot be less than zero.");
        }

        if ( n == 0 ){
            return new ArrayList<>();
        }

        if ( n == 1 ){
            return Arrays.asList(0);
        }

        if ( n == 2 ){
            return Arrays.asList(0, 1);
        }

        List<Integer> seq = new ArrayList<>(n);
        seq.add(0);
        n--;
        seq.add(1);
        n--;

        while(n>0){
            int a = seq.get(seq.size()-2);
            int b = seq.get(seq.size()-1);
            seq.add(a + b);
            n--;
        }

        return seq;
    }
}

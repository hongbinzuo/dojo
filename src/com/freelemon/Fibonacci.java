package com.freelemon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/30/14
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci {
    @Test
    public void testGenerateFibonacci(){
        List<Integer> r = new ArrayList<>();
        r.add(0);
        r.add(1);
        r.add(1);
        r.add(2);
        r.add(3);
        r.add(5);
        r.add(8);
        r.add(13);
        assertEquals(r, generateFibonacci(8));
    }


    public static List<Integer> generateFibonacci(int N){
        if ( N < 0 ){
           throw new IllegalArgumentException("N must not be less than zero");
        }

        if ( N == 0 ){
           return new ArrayList<>();
        }

        if ( N == 1 ){
           return Arrays.asList(0);
        }

        if ( N == 2 ){
           return Arrays.asList(0, 1);
        }

        final List<Integer> seq = new ArrayList<>(N);

        seq.add(0);
        N--;
        seq.add(1);
        N--;

        while(N>0){
            int a = seq.get(seq.size() - 1);
            int b = seq.get(seq.size() - 2);
            seq.add(a+b);
            N--;
        }


        return seq;
    }
}

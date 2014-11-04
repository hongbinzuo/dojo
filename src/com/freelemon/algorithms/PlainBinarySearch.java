package com.freelemon.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/29/14
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlainBinarySearch {

    @Test
    public void testSearch(){
        int[] a =  { 1, 2, 4, 8, 16, 32};
        assertTrue(search(a, 16, 0, a.length - 1));
    }


    public boolean search(int[] a, int x, int lo, int hi){
        //
        //System.out.println("search:"+lo+"->"+hi);

        if (lo >= hi) return false;

        int mid = lo + (hi-lo)/2;

        if (a[mid] == x) return true;

        if (a[mid] > x  ){
            return search(a, x, lo, mid );
        } else {
            return search(a, x, mid+1, hi );
        }
    }
}

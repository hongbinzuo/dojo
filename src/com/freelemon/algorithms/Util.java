package com.freelemon.algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/28/14
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    public static void testResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void exchange(int[] a, int p, int q){
        int t = a[p];
        a[p] = a[q];
        a[q] = t;
    }
}

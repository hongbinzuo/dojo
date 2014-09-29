package com.freelemon;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/28/14
 * Time: 7:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {33, 12, 1, 22, 6, 7, 5, 10, 0, 9};

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    Util.exchange(a, i, j);
                }
            }
        }

        Util.testResult(a);
    }
}

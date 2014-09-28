package com.freelemon;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/28/14
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {33, 12, 1, 22, 6, 7, 5, 10, 0, 9};

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }

        Util.testResult(a);

        // this is a test of github push
        // test again
    }
}

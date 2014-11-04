package com.freelemon.algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/26/14
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickSortNew {
    private static int[] a = {2, 1, 4, 5, 3, 6, 8, 7, 9};

    public static void main(String[] args) {

        QuickSortNew.sort(a);
        testResult();
    }

    private static void testResult() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }


    private static void sort(int[] a, int p, int q) {
        if (p < q) {
            int r = partition(a, p, q);

            sort(a, p, r - 1);
            sort(a, r + 1, q);
        }
    }

    private static int partition(int[] a, int p, int q) {
        int pivot = a[p];
        int i = p;

        for (int j = p + 1; j <= q; j++) {
            if (a[j] <= pivot) {
                i++;
                exchange(a, i, j);
            }
        }

        exchange(a, p, i);

        return i;
    }

    private static void exchange(int[] a, int i, int j) {
        if (null == a || 0 == a.length) return;

        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}

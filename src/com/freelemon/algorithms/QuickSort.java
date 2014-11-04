package com.freelemon.algorithms;

public class QuickSort {

    private static int[] a = {13, 22, 4, 6, 22, 34, 67, 12, 11, 34, 5, 6, 1, 23};

    public static void main(String[] args) {
        sort(a);

        testResult();

    }

    private static void testResult() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
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
        int x = a[p];

        int i = p;

        for (int j = p + 1; j <= q; j++) {
            if (a[j] <= x) {
                i++;
                exch(a, i, j);
            }
        }

        exch(a, i, p);

        return i;
    }

    private static void exch(int[] a, int p, int q) {
        int t = a[p];
        a[p] = a[q];
        a[q] = t;
    }
}
package com.freelemon;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/26/14
 * Time: 9:07 PM
 * This class seems not work for now. will fix it later.
 */

public class HeapSort {


    private int[] a;
    private int N = 0;

    private void testResult() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort(20);
        heapSort.insert(12);
        heapSort.insert(10);
        heapSort.insert(2);
        heapSort.insert(9);
        heapSort.insert(8);
        heapSort.insert(99);
        heapSort.insert(1);

        heapSort.testResult();

    }

    HeapSort(int initCapacity) {
        a = new int[initCapacity + 1]; // keep 0th element unused
    }

    private static void exchange(int[] a, int p, int q) {
        int t = a[p];
        a[p] = a[q];
        a[q] = t;
    }

    public void insert(int x) {
        a[++N] = x;
        swim(N);
    }

    public int delMax() {
        int max = a[1];
        exchange(a, 1, N--);
        a[N + 1] = -1;
        sink(1);
        return max;
    }


    private void swim(int k) {
        while (k > 1 && a[k / 2] < a[k]) {
            exchange(a, k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && a[j] < a[j + 1]) j++;
            if (a[k] >= a[j]) break;
            exchange(a, k, j);
            k = j;
        }

    }
}

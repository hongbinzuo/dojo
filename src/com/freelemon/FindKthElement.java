package com.freelemon;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/28/14
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindKthElement {
    private static int[] a = {5, 13, 2, 8, 12, 11, 0, 4, 6, 7, 1};

    public static void main(String[] args) {
//        int i = partition(a, 0, a.length-1);
//        //System.out.println("after partition: " + i);
//        for (int j=0;j<a.length;j++){
//            System.out.println("after partition: " + a[j]);
//        }

        int x = find(a, 0, a.length - 1, 9);

        System.out.println("the 5th element is: " + x);

    }

    public static int find(int[] a, int p, int r, int i) {
        if (p == r) return a[p];

        int q = partition(a, p, r);

        int k = q - p + 1;

        if (k == i) {
            return a[q];
        } else if (i < k) {
            return find(a, p, q - 1, i);
        } else {
            return find(a, q + 1, r, i - k);
        }
    }


    private static int partition(int[] a, int p, int q) {
        int pivot = a[p];

        int i = p;
        for (int j = p + 1; j <= q; j++) {
            if (a[j] < pivot) {
                i++;
                exchange(a, i, j);
            }
        }

        exchange(a, i, p);
        return i;
    }

    private static void exchange(int[] a, int p, int q) {
        int t = a[p];
        a[p] = a[q];
        a[q] = t;
    }


}

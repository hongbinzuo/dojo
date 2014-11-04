package com.freelemon.algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 10/17/14
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickSortNewNew {

    public void sort(int[] a){
        sort(a, 0, a.length-1);
    }

    private void sort(int[] a, int p, int q){
        if ( p < q ){
            int r = partition(a, p, q);
            sort(a, p, r-1);
            sort(a, r+1, q);
        }
    }

    private int partition(int[] a, int p, int q){
        int pivot = a[p];
        int i = p;

        for(int j=p+1;j<=q;j++){
            if ( a[j] < pivot) {
                i++;
                Util.exchange(a, i, j);
            }
        }

        Util.exchange(a, i, p);

        return i;
    }

}

package com.freelemon.algorithms;

public class MergeSort{


    public static void main(String[] args){
        int[] a = {3,2,4,6,1,23,12,8,7,13};
        MergeSort mergeSort = new MergeSort();

        mergeSort.sort(a);

        Util.testResult(a);
    }

    private void sort(int[] a){
        mergeSort(a, 0, a.length-1);
    }

    private void mergeSort(int[] a, int lo, int hi){
        if ( lo < hi ){
            int m = lo + (hi-lo)/2;
            mergeSort(a, lo, m);
            mergeSort(a, m+1, hi);
            merge(a, lo, m, hi);
        }
    }


    private void merge(int[] a, int lo, int mid, int hi){
        int[] b = new int[a.length];

        int i = lo;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<= hi){
            if ( a[i] <= a[j] ){
                b[k++] = a[i++];
            } else{
                b[k++] = a[j++];
            }
        }

        while (i<=mid){
            b[k++] = a[i++];
        }

        while (j<=hi){
            b[k++] = a[j++];
        }

        for (i = 0; i < k; i++)
            a[lo + i] = b[i];

    }
}
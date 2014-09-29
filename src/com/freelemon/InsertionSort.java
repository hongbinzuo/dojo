package com.freelemon;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/28/14
 * Time: 8:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSort {
    public static void main(String[] args){
        int[] a = {12, 3, 65, 7, 11, 0, 8};

        for (int i=1; i< a.length;i++){
            for (int j=i;j>0&&a[j]<a[j-1];j--){
                Util.exchange(a, j, j-1);
            }
        }
    }
}

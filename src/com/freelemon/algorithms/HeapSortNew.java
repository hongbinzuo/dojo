package com.freelemon.algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 10/17/14
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeapSortNew {
    public void minHeapFixup(int a[], int i)
    {
        int j, temp;

        temp = a[i];
        j = (i - 1) / 2;      //父结点

        while (j >= 0 && i != 0)
        {
            if (a[j] <= temp)
                break;

            a[i] = a[j];     //把较大的子结点往下移动,替换它的子结点
            i = j;
            j = (i - 1) / 2;
        }
        a[i] = temp;
    }



}

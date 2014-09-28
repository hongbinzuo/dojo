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

        int temp;
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    Util.exchange(a, j, j+1);
                }
            }
        }

        Util.testResult(a);
    }

}

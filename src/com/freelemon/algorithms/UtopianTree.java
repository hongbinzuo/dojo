package com.freelemon.algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 10/6/14
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UtopianTree {

    public static List<Integer> grow(int N, List<Integer> years){
        int max = 0;
        for(int i=0;i<years.size();i++){
            int t = years.get(i);
            if (max < t) max = t;
        }

        max++;
        int[] height = new int[max];
        height[0]=1;
        boolean flag = false;
        for(int i =1;i<max;i++){
            if ( flag ) {
                height[i] = height[i-1] + 1;
            } else {
                height[i] = height[i-1] * 2;
            }
            flag = !flag;
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<years.size();i++){
            int t = years.get(i);
            result.add(height[t]);

        }

        return result;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        List<Integer> years = new ArrayList<>();
        int max = 0;

        for(int i =0;i<N;i++){
            int t = in.nextInt();
            years.add(t);
        }

        List<Integer> result = grow(N, years);

        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }


    }
}

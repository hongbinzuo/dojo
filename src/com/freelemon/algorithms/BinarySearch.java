package com.freelemon.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/29/14
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch {

    public static boolean search(final List<Integer> numbers,
                                 final Integer value){
        if ( numbers == null || numbers.isEmpty()) return false;

        final Integer comparison = numbers.get(numbers.size()/2);

        if ( value.equals(comparison)) return true;

        if ( value < comparison)
            return search(numbers.subList(0, numbers.size()/2), value);
        else
            return search(numbers.subList(numbers.size()/2+1, numbers.size()), value);

    }


    public static boolean searchNew(final List<Integer> numbers, final Integer value){
        if ( numbers == null || numbers.isEmpty() ) return false;

        final Integer comparison = numbers.get(numbers.size()/2);

        if ( value.equals(comparison)) return true;

        if ( value < comparison )
            return search(numbers.subList(0, numbers.size()/2), value);
        else
            return search(numbers.subList(numbers.size()/2+1, numbers.size()), value);

    }

/*    public int searchNonRec(int[] a, int value){
        int low =0, high = a.length-1;

        int mid;

        while(low<=high){
            mid = (low+high)/2;

            if(value ==a[mid])
                return mid;
            else if (value < a[mid])
                high = mid-1;
            else if (value > a[mid] )
                low = mid+1;
        }

        return -1;
    }
    */

    public int searchWhile(int[] a, int value){
        int low=0, high=a.length-1;

        int mid;

        while(low<=high){
            mid = (low+high)/2;

            if ( value == a[mid])
                return mid;
            else if ( value < a[mid])
                high = mid-1;
            else if (value > a[mid])
                low = mid+1;
        }

        return -1;
    }


    public static void main(String[] args){
        List<Integer> a = new ArrayList<>(20);
        a.add(12);
        a.add(14);
        a.add(16);
        a.add(20);
        a.add(21);

        System.out.println(BinarySearch.search(a, 22));


    }

}

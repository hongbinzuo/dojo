package com.freelemon.algorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 10/3/14
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class TwoSum {

    @Test
    public void testTwoSum(){
        int[] a= {-3, 4, 3, 90};
        int target = 0;

        int[] result = twoSum(a, target);
        Util.testResult(result);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] numbersCopy = new int[numbers.length];
        System.arraycopy(numbers, 0, numbersCopy, 0, numbers.length);

        Arrays.sort(numbers);

        int i = 0, j = numbers.length-1;
        int index1=-1;
        int index2=-1;
        while(i<j){
            int tmp = numbers[i]+ numbers[j];
            if (tmp == target){
                index1 = i;
                index2 = j;
                break;
            } else if ( tmp < target){
                i++;
            } else if ( tmp > target){
                j--;
            }
        }

        if(index1!=-1 && index2!= -1){
            boolean found1 = false;
            boolean found2 = false;
            for (int k=0;k<numbersCopy.length;k++){
                if(numbersCopy[k] ==numbers[index1] && !found1 ){
                    index1 = k + 1;
                    found1 = true;
                }

                if(numbersCopy[k] ==numbers[index2] && !found2 ){
                    index2 = k + 1;
                    if (index2 > index1 )
                        found2 = true;
                }
            }

        }

        return new int[] {index1, index2} ;

    }

}
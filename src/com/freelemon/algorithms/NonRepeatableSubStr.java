package com.freelemon.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 10/4/14
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class NonRepeatableSubStr {
    @Test
    public void testLenOfLongestSub(){
        int result = lengthOfLongestSubstring("abcdbcaddddacbefesxe");

        System.out.println("Result is:" + result);
    }

    public int lengthOfLongestSubstring(String s) {
        if ( null == s ) return 0;

        HashMap<Integer, Integer> dict = new HashMap<>();

        int max = 0;
        int length = 0;

        for(int i=0;i<s.length();i++){
            length++;

            if (dict.containsKey(s.codePointAt(i)) && (length > i - dict.get(s.codePointAt(i)))){
                length = i - dict.get(s.codePointAt(i));
            }

            max = Math.max(max, length);
            dict.put(s.codePointAt(i), i);
        }

        return  max;

    }

}

package com.freelemon.perf.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-7
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
public class TestSubString {
    public static void main(String[] args) {
        List<String> handler = new ArrayList<String>();

        for (int i = 0; i < 10000 ; i++) {
            HugeStr h = new HugeStr();
            // ImprovedHugeStr h = new ImprovedHugeStr();
            handler.add(h.getSubString(1, 5));
        }
    }


    static class HugeStr {
        private String str = new String(new char[100000]);

        public String getSubString(int begin, int end){
            return str.substring(begin, end);
        }
    }

    static class ImprovedHugeStr{
        private String str = new String(new char[100000]);
        public String getSubString(int begin, int end){
            return new String(str.substring(begin, end));
        }
    }
}

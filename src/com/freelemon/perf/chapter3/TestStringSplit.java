package com.freelemon.perf.chapter3;

import org.junit.Before;
import org.junit.Test;

import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-7
 * Time: 下午4:52
 * To change this template use File | Settings | File Templates.
 */
public class TestStringSplit  {
    private String myStr = null;
    private final static String DELIMETER = ";";

    @Before
    public void setup(){

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
            sb.append(DELIMETER);
        }

        myStr = sb.toString();
    }

    @Test
    public void testSplit(){
        long begin = System.currentTimeMillis();

        for (int i = 0; i < 10000 ; i++) {
            myStr.split(DELIMETER);
        }

        System.out.println("split method takes "+ (System.currentTimeMillis()-begin) + " ms.");
    }

    @Test
    public void testStringTokenizer(){
        long begin = System.currentTimeMillis();

        StringTokenizer st = new StringTokenizer(myStr, DELIMETER);

        for (int i = 0; i < 10000; i++) {
            while(st.hasMoreTokens()){
                st.nextToken();
            }

            st = new StringTokenizer(myStr, DELIMETER);

            //System.out.println("StringTokenizer method takes(1) "+ (System.currentTimeMillis()-begin) + " ms.");
        }

        System.out.println("StringTokenizer method takes "+ (System.currentTimeMillis()-begin) + " ms.");
    }

    @Test
    public void testIndexOf(){
        long begin = System.currentTimeMillis();

        String tmp = myStr;

        boolean test = false;

        for (int i = 0; i < 100; i++) {
            if ( test ) {
                while(true){
                    String splitStr = null;
                    int j = tmp.indexOf(DELIMETER);

                    if (j<0) break;
                    splitStr = tmp.substring(0,j);

                    tmp = tmp.substring(j+1);
                }

            } else {
                int pos = 0, end;
                while ((end = tmp.indexOf(DELIMETER, pos)) >= 0) {
                    String splitStr = null;
                    splitStr = tmp.substring(pos, end);
                    pos = end + 1;
                }
            }

            System.out.println("indexOf method takes(1) "+ (System.currentTimeMillis()-begin) + " ms.");

            tmp = myStr;

        }

        System.out.println("indexOf method takes "+ (System.currentTimeMillis()-begin) + " ms.");
    }

}



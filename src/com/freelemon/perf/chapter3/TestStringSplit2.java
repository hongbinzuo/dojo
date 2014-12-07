package com.freelemon.perf.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-7
 * Time: 下午6:11
 * To change this template use File | Settings | File Templates.
 */
public class TestStringSplit2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 100000; i < 100000 + 60; i++)
            sb.append(i).append(' ');
        String sample = sb.toString();

        int runs = 100000;
        for (int i = 0; i < 5; i++) {
            {
                long start = System.nanoTime();
                for (int r = 0; r < runs; r++) {
                    StringTokenizer st = new StringTokenizer(sample);
                    List<String> list = new ArrayList<String>();
                    while (st.hasMoreTokens())
                        list.add(st.nextToken());
                }
                long time = System.nanoTime() - start;
                System.out.printf("StringTokenizer took an average of %.1f us%n", time / runs / 1000.0);
            }
            {
                long start = System.nanoTime();
                Pattern spacePattern = Pattern.compile(" ");
                for (int r = 0; r < runs; r++) {
                    List<String> list = Arrays.asList(spacePattern.split(sample, 0));
                }

//                for (int r = 0; r < runs; r++) {
//                    List<String> list = Arrays.asList(sample.split(" "));
//                }


                long time = System.nanoTime() - start;
                System.out.printf("Pattern.split took an average of %.1f us%n", time / runs / 1000.0);
            }
            {
                long start = System.nanoTime();
                for (int r = 0; r < runs; r++) {
                    List<String> list = new ArrayList<String>();
                    int pos = 0, end;
                    while ((end = sample.indexOf(' ', pos)) >= 0) {
                        list.add(sample.substring(pos, end));
                        pos = end + 1;
                    }
                }
                long time = System.nanoTime() - start;
                System.out.printf("indexOf loop took an average of %.1f us%n", time / runs / 1000.0);
            }
        }
    }
}

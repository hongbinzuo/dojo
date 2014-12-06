package com.freelemon.perf.chapter2;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-6
 * Time: 下午11:28
 * To change this template use File | Settings | File Templates.
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        Test1.testDirectWrite();
        Test1.testBufferedWrite();
    }

    private static void testDirectWrite() throws IOException{
        Writer writer = new FileWriter(new File("file1.txt"));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 150000; i++) {
            writer.write(i);
        }

        writer.close();
        System.out.println("spent:" + (System.currentTimeMillis()-begin));
    }


    private static void testBufferedWrite() throws IOException{
        Writer writer = new BufferedWriter(new FileWriter(new File("file2.txt")));
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 150000; i++) {
            writer.write(i);
        }

        writer.close();
        System.out.println("spent:" + (System.currentTimeMillis()-begin));
    }




}

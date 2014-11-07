package com.freelemon.concurrency.chp7;

import java.math.BigInteger;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/7/14
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrimeGeneatorTest {
    public List<BigInteger> aSecondOfPrimes() throws InterruptedException{
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();

        try {
            Thread.sleep(1000);
        }finally {
            generator.cancel();
        }

        return generator.get();

    }

    public static void main(String[] args){
        PrimeGeneatorTest test = new PrimeGeneatorTest();
        try {
            List<BigInteger> result = test.aSecondOfPrimes();
            for (BigInteger i: result){
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

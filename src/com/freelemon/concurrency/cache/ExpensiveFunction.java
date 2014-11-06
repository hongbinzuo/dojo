package com.freelemon.concurrency.cache;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/6/14
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}

package com.freelemon;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/30/14
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class FizzBuzz {
    @Test
    public void testFizzBuzz(){
        fizzBuzz(32);
    }


    public void fizzBuzz(int N){
        final String fizz = "Fizz";
        final String buzz = "Buzz";
        final String fizzBuzz = "FizzBuzz";

        String[] result = new String[N];

        for (int i=1;i<=N;i++){
            if ( i % 15 == 0 ){
                System.out.print(fizzBuzz + " ");
            } else if ( i%3 == 0){
                System.out.print(fizz+" ");
            } else if ( i% 5 == 0 ){
                System.out.print(buzz+" ");
            } else {
                System.out.print(i + " ");
            }
        }

        System.out.println();

    }

}

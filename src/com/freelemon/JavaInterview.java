package com.freelemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/28/14
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class JavaInterview {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();

        // new feature in Java 7
        List<Integer> numbers2 = new ArrayList<>();

        // new feature in Java 7
        String st = "test";
        switch (st) {
            case "test":
                System.out.println("What a great day!");
            default:
                System.out.println("no item matches");
        }
    }
}

package com.freelemon.concurrency;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/4/14
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class MutablePoint {
    public int x, y;

    public MutablePoint(){
        x = 0; y = 0;
    }

    public MutablePoint(MutablePoint p){
        this.x = p.x;
        this.y = p.y;
    }
}

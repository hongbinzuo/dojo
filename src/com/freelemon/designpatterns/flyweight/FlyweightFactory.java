package com.freelemon.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/19/14
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlyweightFactory {
    static Map<String, Shape> shapes = new HashMap<String, Shape>();

    public static Shape getShape(String key){
        Shape shape = shapes.get(key);

        if ( shape == null){
            shape = new Circle(key);
            shapes.put(key, shape);
        }

        return shape;
    }

    public static int getSum(){
        return shapes.size();
    }
}

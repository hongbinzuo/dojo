package com.freelemon.designpatterns.flyweight;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/19/14
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Circle extends Shape {
    private String color;
    public Circle(String color){
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drew a circle in " +color);
    }
}

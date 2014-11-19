package com.freelemon.designpatterns.flyweight;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 11/19/14
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    public static void main(String... args){
        Shape shape1 = FlyweightFactory.getShape("red");
        shape1.draw();

        Shape shape2 = FlyweightFactory.getShape("blue");
        shape2.draw();

        Shape shape3 = FlyweightFactory.getShape("red");
        shape3.draw();

        Shape shape4 = FlyweightFactory.getShape("yellow");
        shape4.draw();

        Shape shape5 = FlyweightFactory.getShape("orange");
        shape5.draw();

        Shape shape6 = FlyweightFactory.getShape("red");
        shape6.draw();

        Shape shape7 = FlyweightFactory.getShape("blue");
        shape7.draw();

        Shape shape8 = FlyweightFactory.getShape("blue");
        shape8.draw();

        System.out.println("Total "+FlyweightFactory.getSum()+" shapes generated..");

    }


    //


}

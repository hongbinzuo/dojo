package com.freelemon.perf.chapter2;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-6
 * Time: 下午11:39
 * To change this template use File | Settings | File Templates.
 */
public class NoBufferMovingCircle extends JApplet implements Runnable {
    Image screenImage = null;
    Thread thread;
    int x = 5;
    int move = 1;

    public void init(){
        screenImage = createImage(230, 160);
    }

    public void start(){
        if ( thread == null ){
            thread = new Thread(this);
            thread.start();
        }
    }


    @Override
    public void run() {
        while(true){
            x += move;
            if ( x> 105 || x< 5){
                move *= -1;
            }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public void drawCircle(Graphics gc){
        Graphics2D g = (Graphics2D) gc;
        g.setColor(Color.GREEN);
        g.fillRect(0,0,200,100);
        g.setColor(Color.RED);
        g.fillOval(x, 5, 90, 90);
    }

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 100);
        drawCircle(g);
    }
}

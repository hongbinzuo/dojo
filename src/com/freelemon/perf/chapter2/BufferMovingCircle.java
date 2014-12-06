package com.freelemon.perf.chapter2;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-6
 * Time: 下午11:47
 * To change this template use File | Settings | File Templates.
 */
public class BufferMovingCircle extends NoBufferMovingCircle {
    Graphics doubleBuffer = null;

    @Override
    public void init() {
        super.init();    //To change body of overridden methods use File | Settings | File Templates.
        doubleBuffer = screenImage.getGraphics();
    }

    public void paint(Graphics g){
        doubleBuffer.setColor(Color.white);
        doubleBuffer.fillRect(0, 0, 200, 100);
        drawCircle(doubleBuffer);
        g.drawImage(screenImage, 0, 0, this);
    }
}

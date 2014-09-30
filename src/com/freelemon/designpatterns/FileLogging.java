package com.freelemon.designpatterns;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/29/14
 * Time: 4:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileLogging implements Logging {
    private final File toWrite;

    public FileLogging(final File toWrite ){
        this.toWrite = toWrite;
    }

    @Override
    public void write(final String message){
        try{
            final FileWriter fos = new FileWriter(toWrite);
            fos.write(message);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

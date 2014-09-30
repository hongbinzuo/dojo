package com.freelemon.designpatterns;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/29/14
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoggingClientTest {
    @Test
    public void useConsoleLogging(){
        final LoggingClient c = new LoggingClient(new ConsoleLogging());
        c.doWork(32);
    }

    @Test
    public void useFileLogging() throws IOException {
        final File tmpFile = File.createTempFile("test", "log");
        final LoggingClient c = new LoggingClient(new FileLogging(tmpFile));
        c.doWork(41);
        c.doWork(42);
        c.doWork(43);

        final BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
        assertEquals("Even number: 42", reader.readLine());
        assertEquals(-1, reader.read());

    }


}

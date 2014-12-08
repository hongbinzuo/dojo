package com.freelemon.perf.chapter3.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-8
 * Time: 下午9:51
 * To change this template use File | Settings | File Templates.
 */
public class FileCopy {
    public static void main(String[] args) {
        try {
            FileCopy.nioCopyFile("test.txt", "testcp.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void nioCopyFile(String resource, String destination) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);
        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true){
            buffer.clear();
            int len = readChannel.read(buffer);
            if ( len == -1 )
                break;

            buffer.flip();
            writeChannel.write(buffer);
        }

        readChannel.close();
        writeChannel.close();

    }

}

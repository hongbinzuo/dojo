package com.freelemon.perf.chapter3.nio;

import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-8
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 */
public class TestBuffer {
    public static void main(String[] args) {
        ByteBuffer b = ByteBuffer.allocate(15);

        System.out.print("After allocation done: \t");
        System.out.printf("limit=%s, capacity=%d, position=%d\n", b.limit(), b.capacity(), b.position());

        for (int i = 0; i < 10 ; i++) {
            b.put((byte)i);
        }

        System.out.print("After saving 10 bytes: \t");
        System.out.printf("limit=%s, capacity=%d, position=%d\n", b.limit(), b.capacity(), b.position());

        b.flip();

        System.out.print("After flip():\t\t\t");
        System.out.printf("limit=%s, capacity=%d, position=%d\n", b.limit(), b.capacity(), b.position());


        System.out.print("Reading buffer: \t\t");
        for (int i = 0; i < 5; i++) {
            System.out.print(b.get());
        }

        System.out.print("\nAfter reading 5 bytes: \t");
        System.out.printf("limit=%s, capacity=%d, position=%d\n", b.limit(), b.capacity(), b.position());


        b.flip();

        System.out.print("After flip(): \t\t\t");
        System.out.printf("limit=%2s, capacity=%d, position=%d\n", b.limit(), b.capacity(), b.position());

    }
}

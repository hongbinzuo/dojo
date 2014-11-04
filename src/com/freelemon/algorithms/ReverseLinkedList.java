package com.freelemon.algorithms;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/30/14
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseLinkedList {
    @Test
    public void testReverseList(){
        final LinkedList<String> three = new LinkedList<String>("3", null);
        final LinkedList<String> two = new LinkedList<String>("2", three);
        final LinkedList<String> one = new LinkedList<String>("1", two);

        final LinkedList<String> reversed = reverse(one);

        assertEquals("3", reversed.getElement());
        assertEquals("2", reversed.getNext().getElement());
        assertEquals("1", reversed.getNext().getNext().getElement());

    }

    public <T> LinkedList<T> reverse(LinkedList<T> original){
        if ( original == null) throw new IllegalArgumentException("list cannot be null");

        if (original.getNext() != null) {
            //return new LinkedList(list.getElement(), reverse(list));
            final LinkedList next = original.getNext();
            original.setNext(null);

            final LinkedList<T> othersReversed = reverse(next);
            next.setNext(original);

            return othersReversed;

        } else{
            return original;
        }

    }
}

class LinkedList<T> {
    private T element;
    private LinkedList<T> next;

    public LinkedList(T element, LinkedList<T> next){
        this.element = element;
        this.next = next;
    }

    public T getElement(){
        return element;
    }

    public LinkedList<T> getNext(){
        return next;
    }

    public void setNext(LinkedList<T> next){
        this.next = next;
    }
}

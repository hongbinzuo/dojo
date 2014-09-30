package com.freelemon;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/29/14
 * Time: 1:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTree<E extends Comparable> {
    private E value;
    private SimpleTree<E> left;
    private SimpleTree<E> right;

    public SimpleTree(E value, SimpleTree<E> left, SimpleTree<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public SimpleTree(E value){

    }

//
//    public SimpleTree(E value) {
//        this.value = value;
//    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public SimpleTree<E> getLeft() {
        return left;
    }

    public void setLeft(SimpleTree<E> left) {
        this.left = left;
    }

    public SimpleTree<E> getRight() {
        return right;
    }

    public void setRight(SimpleTree<E> right) {
        this.right = right;
    }

    public boolean search(final E toFind){
        if (toFind.equals(value)){
            return true;
        }

        if (toFind.compareTo(value) < 0 && left!=null){
            return left.search(toFind);
        }

        return right !=null && right.search(toFind);

    }

    public void insert(final E toInsert){
        if (toInsert.compareTo(value) < 0){
            if ( left == null ){
                left = new SimpleTree<>(toInsert, null, null);
            } else {
                left.insert(toInsert);
            }
        } else {
            if ( right == null ){
                right = new SimpleTree<>(toInsert, null, null);
            } else {
                right.insert(toInsert);
            }
        }
    }
}

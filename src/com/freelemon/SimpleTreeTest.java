package com.freelemon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ehonzuo
 * Date: 9/29/14
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTreeTest  {

    @Test
    public void createTree(){
        final SimpleTree<Integer> root = new SimpleTree<Integer>(7, null, null);
        root.insert(3);
        root.insert(9);
        root.insert(10);

        assertTrue(root.search(10));
        assertEquals(Integer.valueOf(10), root.getRight().getRight().getValue());

    }


}

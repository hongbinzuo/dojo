package com.freelemon.algorithms;

import org.junit.Test;

/**
 * Created with IntelliJ I                                                                                                                                                                                                                                                                                  DEA.
 * User: ehonzuo
 * Date: 10/4/14
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddTwoNumsWithLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

        @Test
        public void testAddTwoNumbers(){
            ListNode l1 = new ListNode(0);
            ListNode l2 = new ListNode(0);
            ListNode result = addTwoNumbers(l1, l2);


        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode c1 = l1;
            ListNode c2 = l2;
            ListNode result = new ListNode(0);
            ListNode d = result;
            int sum = 0;

            while( c1 != null || c2 != null ){
                sum /= 10;

                if ( c1 != null) {
                    sum += c1.val;
                    c1 = c1.next;
                }

                if ( c2 != null ){
                    sum += c2.val;
                    c2 = c2.next;
                }

                d.next = new ListNode(sum % 10);
                d = d.next;

            }

            if ( sum / 10 == 1){
                d.next = new ListNode(1);
            }

            return result.next;
        }



}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
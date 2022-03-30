package com.yuyang.linked;

/**
 * @author : Yuyang Sun
 * @date: 3/29/2022, Tue
 **/

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

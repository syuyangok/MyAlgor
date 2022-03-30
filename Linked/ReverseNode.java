package com.yuyang.linked;

/**
 * @author : Yuyang Sun
 * @date: 3/29/2022, Tue
 **/
//give a linkedList, reverse the list
//return new head of reversed (the end in old list)
public class ReverseNode {

    //method to reverse a list.
    static ListNode  reverseNode(ListNode head){
        ListNode cur = head, pre = null, next = head;
        while(cur != null){
            next = cur.next;
            //reverse node
            cur.next = pre;
            //reset pointer
            pre = cur;
            cur = cur.next;
        }
        //cur is  null now, pre is new head;
        return pre;
    }
}

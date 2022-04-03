package com.yuyang.linked;

import java.util.PriorityQueue;

/**
 * @author : Yuyang Sun
 * @date: 4/3/2022, Sun
 **/
//leetcode 23. Merge k Sorted Lists
public class MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        //safe check
        if (lists.length ==0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));

        //add heads to pq
        for (ListNode head : lists){
            if (head != null)     pq.add(head);
        }

        while(!pq.isEmpty()){
            ListNode temp = pq.poll();//take smallest out
            if (temp.next != null) pq.add(temp.next);
            p.next = temp;//add smalest to result link
            p=p.next;//p keep moving forward;
        }

        return dummy.next;
    }
}

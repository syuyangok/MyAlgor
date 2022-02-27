package com.yuyang.api;

import java.util.ArrayList;
//input a linked list.
//output a int array with reverse order.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {

     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }


    ArrayList<Integer> arr = new ArrayList<>();
    public int[] reversePrint(ListNode head) {

        traverse(head);
        int n = arr.size();

        int[] result = new int[n];
        for (int i = 0; i <= n-1 ; i++) {
            result[i] = arr.get(i);
        }
        return result;
    }

    public void traverse(ListNode head){
        if(head == null) {
            return ;
        }
        traverse(head.next);
        //System.out.print(head.val);
        arr.add(head.val);
    }
}

package com.yuyang.linked;

/**
 * @author : Yuyang Sun
 * @date: 4/4/2022, Mon
 **/
//83. Remove Duplicates from Sorted List
public class RemoveDup {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode fast = head, slow = head;

        while(fast != null){

            if(fast.val != slow.val){
                slow.next = fast;//skip duplicatge node
                slow = slow.next;//move slow to next;
            }
            fast = fast.next;//keep moving fast;
        }
        slow.next = null;

        return head;

    }

}

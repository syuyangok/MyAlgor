import java.util.HashSet;

/**
 * @author : Yuyang Sun
 * @date: 1/23/2022, Sun
 **/
 
 //leetcode 141
 //Given head, the head of a linked list, determine if the linked list has a cycle in it.
 // extend, find cycle length
public class linkedListCycle {
 
     //no need to check speical case, best solution!
    public boolean twoPointers(ListNode head) {

        ListNode s1 = head; // pointer 1 slow, step 1
        ListNode s2 = head; // pointer 2 fast, step 2

        //use faster pointer do null check
        while(s2 != null && s2.next != null){
            s1 = s1.next;
            s2 = s2.next.next;

            if(s1 == s2){
                return true;
            }
        }

        return false;
    }
 
 
    //find cycle length, if has cycle, from first two pointers meet, to second pointers meet,
    //the distance is the cycle length
    public int cycleLength(ListNode head) {

        ListNode s1 = head; // pointer 1 slow, step 1
        ListNode s2 = head; // pointer 2 fast, step 2
        int meet = 0;
        int dis = 0;

        //use faster pointer do null check
        while(s2 != null && s2.next != null){
            s1 = s1.next;
            s2 = s2.next.next;
            //if have met.
            if(meet ==1 ){
                dis++;
            }

            if(s1 == s2){
                meet++;
                //if it's second time meet.
                if (meet == 2){
                    return dis;
                }
            }
        }

        return -1;
    }

    public boolean solution5(ListNode head){
        //check special case
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        //if slow == fast, meaning it has cycle.
        while (slow != fast){

            if (fast == null || fast.next == null){
                return false;
            }
            //slow moving one step, fast moving 2 step
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    // no need check special case, head = null
    public boolean solution3(ListNode head){

        HashSet<ListNode> s = new HashSet<>();
        while (head != null){

            if (s.contains(head)){
                return true;
            }
            else{
                s.add(head);
            }
            head = head.next;
        }
        return false;
    }

    //not work, too slow
    public boolean solution(ListNode head){
        //check special case
        if (head == null || head.next == null) return false;

        int head_value = head.val;
        while (head.next != null){
            head = head.next;
            if (head_value == head.val){
                return true;
            }
        }
        return false;
    }

    // need to check special case first, head = null;
    public boolean solution2(ListNode head){

        HashSet<ListNode> s = new HashSet<>();
        //check special case
        if (head == null || head.next == null) return false;

        while (head.next != null){
            head = head.next;
            if (s.contains(head)){
                return true;
            }
            else{
                s.add(head);
            }
        }
        return false;
    }


     //Definition for singly-linked list
     class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

}

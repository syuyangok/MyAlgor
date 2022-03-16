/*
Given a linked list, remove the nth node from the end of list and return its head.
Leetcode 19
*/
import java.util.*;

public class removeNode 
{ 
        
    
 //Definition for singly-linked list.
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    //This method use two pointer to find. 
	//keypoint, keep fast and slow with gap n. 
	//when fast reach the end, the slow next will be target.
    private static ListNode mysolution(ListNode head, int n) 
    {
        ListNode start = new ListNode(0);//Use dummy head incase head be removed.
        start.next = head;
        
        int count = 0;//count
        ListNode temp = start;
        ListNode target;
        
        ListNode tempSlow = start;
        
        while ( temp.next != null) // use slow pointer to find node before target.
        {
            temp = temp.next;
            
            
            if(count >= n)//begin move slow pointer
            {
                tempSlow = tempSlow.next;
            }
            count++;
        }

        //remove target
        target = tempSlow.next;
        tempSlow.next = tempSlow.next.next;
        target.next = null;
        
        
        return start.next;
     
    }//solution end.    
  
  
  
    public static void main (String[] args) 
        {

        }
}
            
          
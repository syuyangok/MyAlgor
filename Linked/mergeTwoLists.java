//leetcode 21
//Merge the two sorted lists in a one sorted list. T
import java.util.*;

public class mergeTwoLists 
{         
    
    //This method use two pointer to find. 
    private ListNode mysolution(ListNode l1, ListNode l2) 
    {
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
        
        while (l1 != null || l2 != null) 
        {
            if (l1 == null || (l2 != null && l1.val >= l2.val)) 
            {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            } 
            else {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            }
        }
        return fakeHead.next;
    }//solution end.    
  
    //methods 2, recursive to solve.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)         return l2;        
        if(l2 == null)         return l1;
        
        ListNode result;
        if (l1.val<=l2.val)
        {
            result = l1;
            l1=l1.next;
            
            result.next = mergeTwoLists(l1, l2);
        }
        else
        {
            result = l2;
            l2=l2.next;
            
            result.next = mergeTwoLists(l1, l2);
        }    
        return result;

    }
  
    public static void main (String[] args) 
        {

        }
}
            
          
/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 The digits are stored in reverse order and each of their nodes contain a single digit. 
 Add the two numbers and return it as a linked list.
 Given 7->1->6 + 5->9->2. That is, 617 + 295.
 Return 2->1->9. That is 912.
 */
public class addTwoNumbers 
{
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) 
        { 
            val = x; 
        }
    }
    
    
    public ListNode mysolution (ListNode l1, ListNode l2)
    {
        ListNode current = new ListNode(0);
        ListNode dummy = current;//set dummy
        int temp = 0;
        
        while(l1 !=null || l2 !=null)//calculate sum first.
        {
            if (l1 !=null)
            {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 !=null)
            {
                temp = l2.val;
                l2 = l2.next;
            }
            
            current.next = new ListNode(temp%10);//calculate value
            current = current.next;
            temp = temp/10;//calculate digit
        }//while end
        
        if (temp != 0) {
            current.next = new ListNode(temp);
        }
        
        return dummy.next;
            
    }//solution end
}
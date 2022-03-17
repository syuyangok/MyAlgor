/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.
The brackets must close in the correct order, 
"()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
import java.util.*;

public class ValidParentheses 
{         
    
    //This method use two pointer to find. 
    private boolean mysolution(String s) 
    {
public class Solution {
    public boolean isValid(String s) {
        
        
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray())
        {
            //check if it's left
            if (c == '(') 
                stack.push(')');
            else if (c == '[') 
                stack.push(']');
            else if (c == '{') 
                stack.push('}');
            else //if not left, check if it is math left
            {
                if (stack.isEmpty() || stack.pop() != c)// put check empty first, otherwise runfalse.
                    return false;
            }
        }
        
        return stack.isEmpty();
        
        
    }
}
    }
        
    

     
    }//solution end.    
  
  
  
    public static void main (String[] args) 
        {

        }
}
            
          
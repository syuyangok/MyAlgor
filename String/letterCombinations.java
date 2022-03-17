/*
Given a digit string, return all possible letter combinations 
that the number could represent in the phone
//leetcode 17
example:
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
import java.util.*;


public class  letterCombinations
{ 
        
     //This method use two pointer to find. O(n) is n2log(n).
    private static List<String> mysolution(String digits)
    {
        LinkedList<String> result = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        if (digits.length() == 0) return result;
        
        result.add("");
        
        for (int i =0; i < digits.length(); i ++)
        {
            int m = Character.getNumericValue(digits.charAt(i));
            
            while(result.peek().length()==i)
            {
                String t = result.remove();
                for(char s : mapping[m].toCharArray())
                    result.add(t+s);
                System.out.println("i =" + i + " :" + result);
            }
        }
        
        System.out.println("peek length :" + result.peek().length()); 
        return result;   
        
    }//solution2 end.    
  
    public static void main (String[] args) 
        {
            mysolution("23");            

            System.out.println("");

        }
}
            
          
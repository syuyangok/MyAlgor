/**
 find the longest common prefix string amongst an array of strings.
 Example
 Input  : {geeksforgeeks¡±, ¡°geeks¡±, ¡°geek¡±, ¡°geezer"}
 Output : "gee"
 
 Key point:
 1 Similar to soluion 2, however, use for loop and while loop.
  Assume the longest common string, then keep shorten!
 2 Solution 2 use two for loop; forward to build the common string.
 
 
 */
import java.util.*;
import java.lang.*;

public class longestCommonPrefix 
{    
    private static String mysolution (String[] strs)
    {
        if(strs == null || strs.length == 0)    return "";
        
        String result = strs[0];
        for(int i=0; i < strs.length; i++)
        {	//using string method indexOf to check substring, return -1 if not found
            while(strs[i].indexOf(result) != 0) // check if the common is not the result
            {
                result = result.substring(0,result.length()-1);// then cut the result from end
            }
        }

        
        return result;
    }//solution end    
    private static String mysolution2 (String[] strs)
    {
        if(strs == null || strs.length == 0)    return "";
        
        
        
        StringBuilder result = new StringBuilder("");
        boolean add = true;
        
        for (int j=0; j < strs[0].length(); j++)
        {
            System.out.println( "j = " + j );
            for (int i =0; i < strs.length; i++)
            {
                if ( j>=strs[i].length() )// if one of char reach end;
                {
                    add = false;
                    break;
                }
                
                if ( strs[i].charAt(j) != strs[0].charAt(j))
                {
                    add = false;
                    break;
                }
            }
            
            if ( !add )
            {
                break;
            }
            
            result.append(strs[0].charAt(j));
             System.out.println( result );
        }
        
        return result.toString();
    }//solution end
    
    public static void main(String args[])
    {
        String[] str ={"geeksforgeeks", "geeks", "geek", "geezer" };
            System.out.println( mysolution(str) );
        }
    }
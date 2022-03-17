/**
 Given a roman numeral, convert it to an integer.
 Input is guaranteed to be within the range from 1 to 3999.
 
 Key point:
 1 know how to express in roman

 
 */
import java.util.*;
import java.lang.*;

public class romanToInt 
{    
    
    private static int mysolution (String s)
    {
        int[] nums = new int[s.length()];
        int result =0;
        
        for (int i =0; i < s.length(); i++)//build an array to store 
        {
            switch(s.charAt(i) )
            {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }   
            
        }
        
        for (int i =0; i< s.length()-1; i++)// take care boundary
        {
            if ( nums[i] < nums[i+1])
            {
                result = result - nums[i];
            }
            else 
            {
                result = result +nums[i];
            }
        }
        
        return result + nums[s.length()-1];//deal with last digit.
        
    }//solution end
    
    public static void main(String args[])
    {
        System.out.println( mysolution("IV") );
    }
}
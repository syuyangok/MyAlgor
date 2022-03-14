/*
Given an array S of n integers, are there elements a, b, c in S 
 find three integers in S such that the sum is closest to a given number, target. 
 Return the sum of the three integers. You may assume that each input would have exactly one solution.
The solution set must not contain duplicate triplets.
*/
import java.util.*;
//import java.lang.math.*;

public class threesumClosest
{ 
        
     //This method use two pointer to find. O(n) is n2log(n).
    private static int mysolution(int[] nums, int target)
    {
        int result = 0;
        
        if (nums.length<=3)
        {
            for (int i =0; i <=nums.length-1; i++)
            {
                result = result + nums[i];
            }                
            return result;
        }
        
        Arrays.sort(nums);//sort for remove duplicate
        result = nums[0] + nums[1] +nums[nums.length-1];
        int temp;
                
        for(int i =0; i < nums.length-2; i++)
        {
            int j =i+1;
            int k = nums.length-1;
            
            while (j<k)                
            {    
               temp = nums[i] + nums[j] +nums[k] ;            
                if(Math.abs(result - target) >Math.abs(temp - target))
                {
                    result = temp;
                    if(result == target)
                    {
                        break;
                    }
                }

                else if(temp - target< 0)// < target, move from left
                {
                    
                    j++;
                }
                else
                {
                   
                    k--;
                }
            }
            //System.out.println("After loop " + i + " temp is: " + temp);   
            

        }//for loop end
        return result;   
        
    }//solution2 end.    
  
    public static void main (String[] args) 
        {
        int[] list = {0,1,2};
            int myresult = mysolution(list, 3);            

            System.out.println("");
            System.out.println(myresult);    
        }
}
            
          
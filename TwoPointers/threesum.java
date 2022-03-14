/*
Given an array S of n integers, are there elements a, b, c in S 
such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
The solution set must not contain duplicate triplets.
*/
import java.util.*;

public class threesum 
{ 
        
    //This method use three for loop. O(n) is n3.
    private static List<List<Integer>> mysolution1 (int[] nums)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);//sort for remove duplicate
        for(int i =0; i < nums.length-2; i++)
        {
            for (int j=i+1; j < nums.length-1; j++)
            {

                for (int k=j+1; k < nums.length; k++)
                {
                    if (k < nums.length-1 && nums[k] == nums[k+1])
                    {
                        continue;
                    }
                    if (nums[i] + nums[j] +nums[k] == 0)
                    {
                        ArrayList<Integer> match = new ArrayList<Integer>();
                        match.add(nums[i]);
                         match.add(nums[j]);
                        match.add(nums[k]);
                        result.add(match);
                    }
                }
            }
        }
        return result;        
    }//solution1 end.

    //This method use two pointer to find. O(n) is n2log(n).
    private static List<List<Integer>> mysolution2(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);//sort for remove duplicate
        for(int i =0; i < nums.length-2; i++)
        {
            if (i>0 && nums[i] == nums[i-1])//remove duplicate
            {
                continue;
            }
            int j =i+1;
            int k = nums.length-1;
            while (j<k)
            {
                    if (nums[i] + nums[j] +nums[k] == 0)
                    {
                        List<Integer> match = new ArrayList<Integer>();
                        match.add(nums[i]);
                        match.add(nums[j]);
                        match.add(nums[k]);
                        result.add(match);
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                        while (j < k && nums[k] == nums[k + 1]) k--; 
                    }
                    else if(nums[i] + nums[j] +nums[k] < 0)
                    {
                        j++;
                    }
                    else
                    {
                        k--;
                    }
            }

        }//for loop end
        return result;   
        
    }//solution2 end.    
  
    public static void main (String[] args) 
        {
        int[] list = {-1, 0, 1, 2, -1, -4};
            List<List<Integer>> myresult = mysolution2(list);            

            System.out.println("");
        for (List<Integer>x:  myresult)
            {
                for (int y =0; y<x.size(); y++)
                {                    
                    System.out.println(x.get(y));           
                }
            }

        }
}
            
          
/*
Given an array of integers that is already sorted in ascending order, 
find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
*/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] result = {-1, -1};

                
        Arrays.sort(numbers);
        int i, j, sum;
        result[0] =-1;
        result[1] =-1;
        
        i = 0;// one pointer to start
        j = numbers.length-1;// another pointer to end
        
        while(i<=j)
        {
            sum = numbers[i] + numbers[j];         
            if (sum == target)//find target
            {
                 result[0] = i+1;//samller one
                result[1] = j+1;
                 break;
            }
            else if (sum < target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        
        return result;  
        
    }
}


//longest consecutive subsequence, it is differnece with Leetcode 128, longest consecutive sequence, 
//Leetcode problem is a more like a consecutive subset, 
//for [2, 1, 3], leetcode will calculate length of 1,2,3,    but this should calculate 2,3
//for leetcode 128, we can put all data in a hashset, then pre scan find start, and then next scan find end


//Solution 1, use classis dp 
public class Solution {
	
	public int longestConsecutive(int[] nums){
		
		int n = nums.length;
		
		int[] dp = new int[n];
		
		// base 
		dp[0] = 1;
		
		// dp define subproblem , dp[i] is longest length from 0 to i, ending at i
		for (int i =1; i<n; i++){
			for (int j=0; j<i; j++){
				if( num[i] = num[j] + 1){
					dp[i] = Math.max(dp[j]+1, dp[i])
				}		
				
			}
		}
		
		
		//return
		int ret = 0;
		
		for (int i =0; i<n; i++){
			ret = Math.max(dp[i], ret);
		}
		return ret;
	}
	
}

// Solution 2, use hashMap scan once.
class Solution {
    public int lengthOfLcS(int[] nums) {
        int n = nums.length;
        if(n<=0) return 0;
        if(n == 1) return 1;

        Map<Integer, Integer> map = new HashMap();
        int ret = 1;
        map.put(nums[0], 1);
        for(int i = 1; i<n ; i++){
            int pre = nums[i]-1;
            // has pre continous number, then use current number replace
            // pre nubmer and increase the length
            if (map.containsKey(pre)){
                int temp = map.get(pre);
                map.remove(pre);
                int currentLen = temp + 1;
                map.put(nums[i], currentLen);
                ret = Math.max(ret, currentLen);
            } else {
                if (!map.containsKey(nums[i])){
                    map.put(nums[i], 1);
                }
            }

        }

        return ret;
    }
}


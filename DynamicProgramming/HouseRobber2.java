//leetcode 213
// rob house, first and last house are a circle, can not rob at same time.

class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n<=0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        
        int[] dp_first = new int[n]; //rob first house, so not rob last house
        int[] dp_last = new int[n]; //rob last house, so not rob first house
        
        //rob first
        dp_first[0] = nums[0];
        dp_first[1] = Math.max(nums[0],nums[1]);
        
        for(int i =2; i<=n-2; i++){
            dp_first[i] = Math.max(dp_first[i-1], dp_first[i-2]+ nums[i]);
        }
        
        //rob last
        dp_last[0] = nums[1];
        dp_last[1] = Math.max(nums[1],nums[2]);
        
        for(int i =2; i<=n-2; i++){
            int current_house = nums[i+1];
            dp_last[i] = Math.max(dp_last[i-1], dp_last[i-2]+ current_house);
        }
        
        return Math.max( dp_first[n-2], dp_last[n-2]);
    }
}

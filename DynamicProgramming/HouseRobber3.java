//leetcode 337
// tree dp
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] dp = dpRob(root);
        //0/1 meaning not rob/rob
        return Math.max(dp[0], dp[1]);
    }
    
    public int[] dpRob(TreeNode root){
        //0/1 meaning not rob/rob
        int[] dp = new int[2];
        //base case
        if(root == null) return dp;
        
        int[] left = dpRob(root.left);
        int[] right = dpRob(root.right);
        
        dp[1] = left[0] + right[0] + root.val;//rob root, not rob child
        // if not rob root, child can both rob or not rob. pick max 0/1 for child.
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return dp;
        
        
    }
}

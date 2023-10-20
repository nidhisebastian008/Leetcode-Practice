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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return minDepthRec(root);
    }
    public int minDepthRec(TreeNode root) {
        if(root==null)return Integer.MAX_VALUE;
        int ans=Math.min(minDepthRec(root.left),minDepthRec(root.right));
        return ans==Integer.MAX_VALUE?1:ans+1;
    
}
}
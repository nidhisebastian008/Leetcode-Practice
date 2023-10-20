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
    // Based on the special property of the tree, we can guarantee that the root node is the smallest node in the tree. We just have to recursively traverse the tree and find a node that is bigger than the root node but smaller than any existing node we have come across.
    public int findSecondMinimumValue(TreeNode root) {
    
    int val = helper(root,root.val);
    
    return val == root.val ? -1 : val;
    
}

private int helper(TreeNode root, int globalmin) {
    
    if (root.left == null && root.right == null) return root.val;
    
    int left = helper(root.left,globalmin);
    int right = helper(root.right,globalmin);
    
    int min = Math.min(left, right);
    int max = Math.max(left, right);
    
    return min == globalmin ? max : min;
}
}
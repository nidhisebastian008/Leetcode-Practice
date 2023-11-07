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
    class Pair
    {
        int RTNsum=0;//curr node inclusing to any node max pat sum
        int NTNsum=Integer.MIN_VALUE;//cuur node incl or excluding any node to node sum
        // int 
    }
    public int maxPathSum(TreeNode root) {
        
        return maxPathSumH(root).NTNsum;
    }
    public Pair maxPathSumH(TreeNode root) {
        if(root==null) return new Pair();
        Pair ls=maxPathSumH(root.left);
        Pair rs=maxPathSumH(root.right);

        Pair myPair= new Pair();
        int RTNsum=Math.max(ls.RTNsum,rs.RTNsum)+root.val;
        int NTNsum=findMultiMax(ls.NTNsum,rs.NTNsum,root.val,ls.RTNsum+rs.RTNsum+root.val,RTNsum);
        myPair.RTNsum=Math.max(root.val,RTNsum);
        myPair.NTNsum=NTNsum;
        return myPair;

        
        
    }
    public int findMultiMax(int... arr)
    {
        int max=arr[0];
        for(int el:arr)max=Math.max(max,el);
        return max;
    }
}
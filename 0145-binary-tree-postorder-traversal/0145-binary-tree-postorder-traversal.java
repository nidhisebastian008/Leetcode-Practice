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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.right==null)
            {
             ans.add(0,curr.val);
             curr=curr.left;  
            }
            else
            {
                TreeNode leftMost=leftMostOfRightNode(curr);
                if(leftMost.left==null)//thread create
                {
                    leftMost.left=curr;
                    ans.add(0,curr.val);
                    curr=curr.right;
                }
                else//thread break//right  khtm
                {
                    leftMost.left=null;
                    curr=curr.left;

                }
            }
        }
        return ans;
        
    }
    TreeNode leftMostOfRightNode(TreeNode node)
    {
        TreeNode ans=node.right;
        while(ans.left!=null&&ans.left!=node)
        {
            ans =ans.left;
        }
        return ans;
    }
}
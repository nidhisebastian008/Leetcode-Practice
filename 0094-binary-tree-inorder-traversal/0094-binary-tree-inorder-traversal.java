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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
             ans.add(curr.val);
             curr=curr.right;  
            }
            else
            {
                TreeNode rightMost=rightMostOfLeftNode(curr);
                if(rightMost.right==null)//thread create
                {
                    rightMost.right=curr;
                    curr=curr.left;
                }
                else//thread break//left  khtm
                {
                    ans.add(curr.val);
                    rightMost.right=null;
                    curr=curr.right;

                }
            }
        }
        return ans;
        
    }
    TreeNode rightMostOfLeftNode(TreeNode node)
    {
        TreeNode ans=node.left;
        while(ans.right!=null&&ans.right!=node)
        {
            ans =ans.right;
        }
        return ans;
    }
}
/**
 * Definition for a binary tree TreeNode.
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
    public List<Integer> preorderTraversal(TreeNode root) {
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
                    ans.add(curr.val);
                    curr=curr.left;
                }
                else//thread break//left  khtm
                {
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
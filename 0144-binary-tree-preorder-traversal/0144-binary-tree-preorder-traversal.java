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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
        iterPre(root,ans);
        return ans;
    }
    class TPair{
        TreeNode node=null;
        boolean selfdone=false;
        boolean leftdone=false;
        boolean rightdone=false;
        TPair(TreeNode node, boolean selfdone,boolean leftdone, boolean rightdone){
            this.node=node;
            this.selfdone=selfdone;
            this.leftdone=leftdone;
            this.rightdone=rightdone;
        }
    }
    public void iterPre(TreeNode root,List<Integer>ans) {
        Stack<TPair> st = new Stack<>();
        st.push(new TPair(root,false,false,false));
        while(st.size()!=0)
        {
            if(st.peek().selfdone==false)
            {
                st.peek().selfdone=true;
                ans.add(st.peek().node.val);
            }
            else if(st.peek().leftdone==false)
            {
                st.peek().leftdone=true;
                if(st.peek().node.left!=null)st.push(new TPair(st.peek().node.left,false,false,false));
            }
            else if(st.peek().rightdone==false)
            {
                st.peek().rightdone=true;
                if(st.peek().node.right!=null)st.push(new TPair(st.peek().node.right,false,false,false));

            }
            else
            {
                st.pop();
            }
            
        }

        
    }

}
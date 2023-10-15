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
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return iterHeight(root);
    }
        
    
    class TPair{
        TreeNode node=null;
        boolean selfdone=false;
        boolean leftdone=false;
        boolean rightdone=false;
        boolean isLeft=false;
        int ld=0;
        int rd=0;
        int sd=0;
        TPair(TreeNode node, boolean selfdone,boolean leftdone, boolean rightdone,boolean isLeft){
            this.node=node;
            this.selfdone=selfdone;
            this.leftdone=leftdone;
            this.rightdone=rightdone;
            this.isLeft=isLeft;
        }
    }
    public int iterHeight(TreeNode root) {
        Stack<TPair> st = new Stack<>();
        st.push(new TPair(root,false,false,false,false));
        TPair rem=null;
        while(st.size()!=0)
        {
            if(st.peek().leftdone==false)
            {
                st.peek().leftdone=true;
                if(st.peek().node.left!=null)st.push(new TPair(st.peek().node.left,false,false,false,true));
            }
            else if(st.peek().rightdone==false)
            {
                st.peek().rightdone=true;
                if(st.peek().node.right!=null)st.push(new TPair(st.peek().node.right,false,false,false,false));

            }
            else if(st.peek().selfdone==false)
            {
                st.peek().selfdone=true;
                st.peek().sd=Math.max(st.peek().ld,st.peek().rd)+1;
                // System.out.println(st.peek().node.val+"->"+st.peek().sd);
            }
            else
            {
                 rem=st.pop();
                if(st.size()!=0){
                    if(rem.isLeft){
                        st.peek().ld=rem.sd;
                        //  System.out.println(st.peek().node.val+"ld is"+st.peek().ld);
                        }
                    else {
                       st.peek().rd=rem.sd;
                        // System.out.println(st.peek().node.val+"rd is"+st.peek().rd);
                        }
                }
            }
            
        }
        
        return rem.sd;
    }
    
}
            

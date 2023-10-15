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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int len=postorder.length;
       return constructFromPrePostRec(preorder,postorder,0,len-1,0,len-1); 
    }
    public TreeNode constructFromPrePostRec(int[] pre, int[] po,int posi,int poei,int psi, int pei)     
    {
        if(psi>pei||posi>poei) return null;
        TreeNode root= new TreeNode(pre[psi]);
        if(psi==pei)return root;
        int idx=posi;
        while(pre[psi+1]!=po[idx])idx++;
        int tel=idx-posi+1;  

        root.left=constructFromPrePostRec(pre, po,posi,idx,psi+1,psi+tel);
        root.right=constructFromPrePostRec(pre, po,idx+1,poei-1,psi+tel+1,pei);
        return root;
    }
}
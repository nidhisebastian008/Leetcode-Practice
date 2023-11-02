class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results =new LinkedList<>();
        LinkedList<Integer> lst=new LinkedList<>();
        helper(root,sum,lst,results);
        return results;
    }
    
    private void helper(TreeNode root, int sum, LinkedList<Integer> lst, List<List<Integer>> results){
        if(root==null) return;
        sum-=root.val;
        lst.add(root.val);
        if(root.left==null && root.right==null && sum==0){
            results.add(new ArrayList<Integer>(lst));
        }
        helper(root.left,sum,lst,results);
        helper(root.right,sum,lst,results);
        lst.removeLast();
    }
}
class Solution {
    int maxv=Integer.MIN_VALUE;
    public int maxValue(TreeNode root){
        if(root==null) return 0;
        int left=Math.max(0,maxValue(root.left));
        int right=Math.max(0,maxValue(root.right));
        maxv=Math.max(maxv,left+right+root.val);
        return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        maxValue(root);
        return maxv;
    }
}
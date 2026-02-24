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
    public boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null)return true;
        return false;
    }
    public void helper(TreeNode root,StringBuilder sb,int max[]){
        sb.append(root.val);
        if(isLeaf(root)){
            max[0]+=Integer.parseInt(sb.toString(), 2);
        }
        if(root.left!=null){
            helper(root.left,sb,max);
        }
        if(root.right!=null){
            helper(root.right,sb,max);
        }
        sb.deleteCharAt(sb.length()-1);
    }
    public int sumRootToLeaf(TreeNode root) {
        int[] max = {0};
        StringBuilder sb = new StringBuilder();
        if(isLeaf(root))return root.val;
        helper(root,sb,max);
        return max[0];
    }
}
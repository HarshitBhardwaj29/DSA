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
    public int number(TreeNode root){
        if(root==null)return 0;
        int left = number(root.left);
        int right = number(root.right);
        return 1+left+right;
    }
    public int sum(TreeNode root){
        if(root==null)return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
    public void helper(TreeNode root,int[] arr){
        if(root==null)return;
        if(sum(root)/number(root)==root.val){
            arr[0]++;
        }
        helper(root.left,arr);
        helper(root.right,arr);
    }
    public int averageOfSubtree(TreeNode root) {
        int[] arr = new int[1];
        helper(root,arr);
        return arr[0];
    }
}
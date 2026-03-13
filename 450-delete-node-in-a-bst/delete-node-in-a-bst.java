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
    public TreeNode helper(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        if(root.val==key){
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode ans = helper(root.right);
            root.val = ans.val;
            root.right=deleteNode(root.right,ans.val);
        }
        else if(key<root.val){
            root.left = deleteNode(root.left,key);
        }
        else if(key>root.val){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}
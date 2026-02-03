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
    List<String> list = new ArrayList<>();
    public boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }
    public void helper(TreeNode root, String ans){
        if(root == null) return;
        if(isLeaf(root)){
            list.add(ans);
            return;
        }
        if(root.left != null){
            helper(root.left, ans + "->" + root.left.val);
        }
        if(root.right != null){
            helper(root.right, ans + "->" + root.right.val);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return list;
        helper(root, "" + root.val);
        return list;
    }
}

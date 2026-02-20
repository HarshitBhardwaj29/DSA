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
    public void inorder(TreeNode root,ArrayList<Integer> list ){
        if(root==null)return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        int min = Integer.MAX_VALUE;
        int prev = list.get(0);
        for(int i=1;i<list.size();i++){
            min = Math.min(min,list.get(i)-prev);
            prev=list.get(i);
        }
        return min;
    }
}
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
    public TreeNode helper(int[] postorder,int psts,int pste,int[] inorder,int ins,int ine,HashMap<Integer,Integer> inMap){
        if(psts>pste || ins>ine) return null;
        TreeNode root = new TreeNode(postorder[pste]);
        int inRoot = inMap.get(postorder[pste]);
        int leftnums = inRoot-ins;
        root.left = helper(postorder,psts,psts+leftnums-1,inorder,ins,inRoot-1,inMap);
        root.right = helper(postorder,psts+leftnums,pste-1,inorder,inRoot+1,ine,inMap);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        int n = postorder.length;
        int m = inorder.length;
        return helper(postorder,0,n-1,inorder,0,m-1,inMap);
    }
}
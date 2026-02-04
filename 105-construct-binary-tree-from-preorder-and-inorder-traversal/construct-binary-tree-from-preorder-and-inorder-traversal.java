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
    public TreeNode helper(int[] preorder,int pres,int pree,int[] inorder,int ins,int ine,Map<Integer,Integer> inMap){
        if(pres>pree || ins>ine) return null;

        TreeNode root = new TreeNode(preorder[pres]);
        int inRoot = inMap.get(preorder[pres]);
        int numsleft = inRoot-ins;

        root.left = helper(preorder,pres+1,pres+numsleft,inorder,ins,inRoot-1,inMap);
        root.right = helper(preorder,pres+numsleft+1,pree,inorder,inRoot+1,ine,inMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        int pres=0;
        int pree=preorder.length-1;
        int ins=0;
        int ine=inorder.length-1;
        return helper(preorder,pres,pree,inorder,ins,ine,inMap);
    }
}
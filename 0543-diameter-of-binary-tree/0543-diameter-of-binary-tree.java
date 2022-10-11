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
    int diameter =0;
    public int diameterOfBinaryTree(TreeNode root) {
        computeHeight(root);
        return diameter;
    }
    
    int computeHeight(TreeNode root){
        //base case 
        if (root == null) return -1;
        int l = computeHeight(root.left);
        int r = computeHeight(root.right);
        diameter = Math.max(diameter, l+r+2);
        return Math.max(l,r)+1;
    
    }
}
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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        return search(root, val);
    }
    
    TreeNode search(TreeNode root, int val){
        if (root.val == val)return root;
        
        if (root.left !=null){
            TreeNode left = search (root.left, val);
            if (left != null) return left;
        }
        if (root.right != null) {
           TreeNode right = search (root.right, val);
            if (right != null) return right;
        }
        return null;
    }
}
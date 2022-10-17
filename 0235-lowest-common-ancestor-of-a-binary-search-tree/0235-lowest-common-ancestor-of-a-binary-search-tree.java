/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null ) return null;
        
        
        /* Recursive solution
        // using BST feature of left or right greater stuff
        int cur = root.val;
        if (cur < p.val && cur < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if (cur > p.val && cur > q.val)
            return lowestCommonAncestor (root.left, p, q);
        // if not found in left or right current root is the LCA
        return root; 
        */
        
        // Iterative Solution
        while (root !=null){
            if ( root.val < p.val && root.val < q.val) root = root.right;
            else if ( root.val > p.val && root.val > q.val) root = root.left;
            else return root;
        }
        return null;
        
    }
}
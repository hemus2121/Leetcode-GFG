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
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return consPreOrder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    /* TreeNode  consPreOrder(int [] preorder, int bound,  int []index){
        if (index[0] == preorder.length || preorder[index[0]]> bound ) return null;
        
        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = consPreOrder(preorder,root.val, index );
        root.right = consPreOrder(preorder, bound, index);
        return root;
    } */
    
    TreeNode consPreOrder(int[] preorder, int low, int upper){
        // base case
        if (index == preorder.length) return null ;
        int val = preorder[index];
        
        if (val > upper || val < low) return null;
         // place the current element
        // and recursively construct subtrees
        index++;
        TreeNode root = new TreeNode(val);
        root.left = consPreOrder(preorder, low, val);
        root.right = consPreOrder(preorder, val, upper);
        return root;
    }
}
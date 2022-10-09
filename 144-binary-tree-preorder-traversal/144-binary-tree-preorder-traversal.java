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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List <Integer> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
        
    }
    
    void  preOrderTraversal(TreeNode root, List <Integer> result){
        //base case
        if(root == null) return ;
        result.add(root.val);
        preOrderTraversal(root.left, result);
        preOrderTraversal(root.right, result);         
    }
}
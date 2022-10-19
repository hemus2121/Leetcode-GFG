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
    void inorder(TreeNode root, List<Integer> resultList){
        if (root == null) return ;
        inorder(root.left, resultList);
        resultList.add(root.val);
        inorder(root.right, resultList);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        
        List<Integer> resultList = new ArrayList();
        inorder(root, resultList);
        int i =0, j = resultList.size()-1;
        while (i<j){
            int sum = resultList.get(i)+ resultList.get(j);
            if (sum == k) return true;
            else if (sum < k) i++;
            else j--;
        }
        return false;
    }
}
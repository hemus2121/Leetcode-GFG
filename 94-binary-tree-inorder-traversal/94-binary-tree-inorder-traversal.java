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
    public List<Integer> inorderTraversal(TreeNode root) {
        //using extra stack 
        Stack <TreeNode> st = new Stack();
        List<Integer> resultList = new ArrayList();
        TreeNode node = root;
        
        while (true){
            
            if (node != null){
                st.add(node);
                node = node.left;
            }else {
                if (st.isEmpty()) break;
                node = st.pop();
                resultList.add(node.val);
                node = node.right;
            }
        }
        return resultList;
    }
}
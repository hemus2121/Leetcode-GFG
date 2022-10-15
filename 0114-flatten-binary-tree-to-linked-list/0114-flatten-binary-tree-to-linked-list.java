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
    public void flatten(TreeNode root) {
        if (root == null) return ;
        Stack <TreeNode> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()){
            TreeNode cur = st.pop();
            if (cur.right !=null){
                st.add(cur.right);
            }
            if(cur.left !=null){
                st.add(cur.left);
            }
            if (!st.isEmpty()){
                cur.right = st.peek();
            }
            cur.left=null;
        }
    }
}
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        //using level order traversal only
        List<List<Integer>> resultList = new ArrayList();
        Queue <TreeNode>  q = new LinkedList();
        boolean flag= true;// indicates level direction changes
        
        if (root == null) return resultList;
        q.add(root);
        
        while (!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> subList = new ArrayList<>();
            
            for (int i=0;i< levelSize;i++){
                TreeNode  node = q.poll();
                //if left is not empy
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                
                // depending on flag add at last or first depeding on flag 1 or 0
                if (flag==true) subList.add(node.val);
                else subList.add(0, node.val);
            }
            flag = !flag; //reverse flag direction
            resultList.add(subList);
        }
        return resultList;
    }
}
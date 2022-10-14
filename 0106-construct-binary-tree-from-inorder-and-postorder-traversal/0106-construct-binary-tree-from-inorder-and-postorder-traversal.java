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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         Map <Integer, Integer> inorderMap = new HashMap<>();
        for (int i =0;i< inorder.length;i++){
            inorderMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1,  inorderMap);
    }
    
  TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> inorderMap) {
      //base condition
        if (ps >pe || is >ie){
            return  null;
        }
      
     TreeNode root = new TreeNode(postorder[pe]);
      
     int rootIndex = inorderMap.get(postorder[pe]);// get root index
     int leftNums = rootIndex -is; //get left elements 
     
     root.left = build(inorder, is, rootIndex-1, postorder, ps, ps+leftNums-1, inorderMap);
     root.right = build(inorder, rootIndex+1, ie, postorder, ps+leftNums, pe-1, inorderMap);
     return root;
        
    }
}
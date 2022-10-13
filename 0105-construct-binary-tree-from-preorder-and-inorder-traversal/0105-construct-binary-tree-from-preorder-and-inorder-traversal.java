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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //put inorder elements into map , element <--> index
       Map < Integer, Integer > inMap = new HashMap < Integer, Integer > ();

        for (int i =0;i< inorder.length;i++){
           inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }
    
    TreeNode buildTree(int [] preorder, int ps,int pe, int [] inorder, int is, int ie, Map<Integer,Integer> iMap ){
        
        //base case
        if (ps > pe || is >ie) return null;
        
        TreeNode root = new TreeNode(preorder[ps]);
        int rootIndex = iMap.get(root.val);
        int leftElements  = rootIndex- is;
        root.left = buildTree(preorder, ps+1, ps+leftElements, inorder, is, rootIndex-1, iMap);
        root.right = buildTree(preorder, ps+leftElements+1, pe, inorder, rootIndex+1, ie, iMap);
        return root;
    }
}
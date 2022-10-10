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
    
   
      class Tuple{
        TreeNode node;
        int vertical;
        int level;
        Tuple (TreeNode node, int level, int row){
            this.node = node;
            this.vertical = level;
            this.level = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tuple > q = new LinkedList < Tuple > ();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap < > ());
            }
            
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue < > ());
            }
            map.get(vertical).get(level).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, vertical - 1, level + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, vertical + 1, level + 1));
            }
        }
        List < List < Integer >> list = new ArrayList ();
        for (TreeMap < Integer, PriorityQueue <Integer>> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue <Integer> nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Store all the nodes of 1 list in the set
        Set<ListNode> dataSet = new HashSet();
        while (headA != null){
            dataSet.add(headA);
            headA = headA.next;
        }
        
        // check whether 2nd list elements are present in set if yes return intersectio point
        while (headB != null){
            if (dataSet.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;        
    }
}
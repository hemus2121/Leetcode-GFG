/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode currentHead = new ListNode();
        currentHead.next = head;
        
        ListNode slow= currentHead;
        ListNode fast = currentHead;
    
        
        //iterate for n nodes from front
        for (int i =1;i<= n;i++){
            fast = fast.next;
        }
        
        while ( fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return currentHead.next;
    }
}
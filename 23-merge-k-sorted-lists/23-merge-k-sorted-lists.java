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
    public ListNode mergeKLists(ListNode[] lists) {
        
        //edge cases if list is null
        if (lists ==null || lists.length ==0) return null;
        
        //Priority Que to hold values in Ascending order of ListNode values
        PriorityQueue <ListNode> pq = new PriorityQueue<>((o1, o2) -> (o1.val-o2.val));
        
        //Add  list elements to pq 
        for (ListNode listNode: lists){
            if (listNode !=null)
                 pq.offer(listNode);
        }
              
        //create a dummy node as result node
        ListNode resultNode = new ListNode(0);
        ListNode head = resultNode;
        
        while (!pq.isEmpty()){
            ListNode currListNode  = pq.poll();
            //check if current node next is not null before add adding to pq
            if (currListNode.next !=null){
                pq.offer(currListNode.next);
            }
            //assign dummy result next node to polled value 
            head.next = currListNode;
            head = head.next; //move to next node 
        }  
        return resultNode.next;
    }
}
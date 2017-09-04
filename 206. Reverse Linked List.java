/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode dumyHead = new ListNode(0);
        dumyHead.next = null;
        ListNode next = null;
        
        for(ListNode node = head; node != null; node = next){
            
            next = node.next;
            
            node.next = dumyHead.next;
            dumyHead.next = node;
        }
        
        return dumyHead.next;
    }
}
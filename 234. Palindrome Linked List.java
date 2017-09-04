/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        ListNode dummyHeaad = new ListNode(0);
        dummyHeaad.next = null;
        
        // reverse first half
        while(fast != null && fast.next != null){
            fast = fast.next.next;// move fast
            
            ListNode tmp = slow.next;
            // reverse
            slow.next = dummyHeaad.next;
            dummyHeaad.next = slow;
            
            slow = tmp;// move slow
            
        }
        
        // find left half and right half
        ListNode left = dummyHeaad.next;
        ListNode right = fast == null ? slow : slow.next;
        
        // judge 
        while(left != null && right != null){
            
            if(left.val != right.val) return false;
            
            left = left.next;
            right = right.next;
        }
        
        return true;
        
    }
}
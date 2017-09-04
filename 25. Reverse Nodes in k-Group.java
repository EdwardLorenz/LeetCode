/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead  = new ListNode(0);
        dummyHEad.next = head;
        ListNode cur = dummyHead;
        ListNode tail = head;
        while(tail != null){
            int n = k;
            while(tail != null && n > 0){
                 tail = tail.next;
                 n --;
            }
               
            if(n == 0){
                ListNode newtail = cur.next;// after reverse, this will be the new tail
                cur.next = reverse(cur.next, tail);
                cur = newtail;
            }
        }
        return dummyHead.next;
        
    }
    //1 2 3 4
    //4 < 1 2->3>4
    //4 < 1 < 2 3>4
    
    public ListNode reverse(ListNode head, ListNode tail){
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = tail;
        
        while(head != tail){
            
            ListNode next = head.next;
            
            // pick a node down from original list, add to new list 
            head.next = dummyHead.next;
            dummyHead.next = head;
            
            head = next;
            
        }
        
        return dummyHead.next;
        /*
        ListNode pre = tail;
        while(head != tail){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;*/
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a,  ListNode b){// ascending
                return a.val - b.val;
            }
        });
        
        //init
        for(ListNode n : lists){
            if(n != null)  heap.offer(n);
        }
        
        //sort
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        
        while(!heap.isEmpty()){
            ListNode selected = heap.poll();
            
            ListNode remaining = selected.next;
            
            // insert to taid
            tail.next = selected;
            tail = selected;
            
            if(remaining != null){
                heap.offer(remaining);
            }
            
        }
        
        tail.next = null;
        
        return dummyHead.next;
        
        
    }
}
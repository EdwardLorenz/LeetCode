/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        TreeLinkNode cur = root;
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        
        while(cur != null){
            while(cur != null){
            // left
            if(cur.left != null){
                if(pre == null){// find a head of next level
                    head = cur.left;
                }else{
                    pre.next = cur.left;// connect to previous node
                }
                
                pre = cur.left;
            }
            
            // right
            if(cur.right != null){
                if(pre == null){// find a head of next level
                    head = cur.right;
                }else{// connect to previous node
                    pre.next = cur.right;
                }
                pre = cur.right;
            }
            
            cur = cur.next;
        }
        // go next level
        cur = head;
        head = null;
        pre = null;
        }
        
        
    }
}
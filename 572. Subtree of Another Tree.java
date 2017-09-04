/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(check(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean check(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        else if(s == null || t == null || s.val != t.val)
            return false;
        else return check(s.left, t.left) && check(s.right, t.right);
    }
    
    /*
        with a global variable
    */
      boolean result = false;
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if(s == null || t == null) return false;
        
        traverse(s,t);
        return result;
    }
    
    private void traverse(TreeNode node,TreeNode t){
        if(node == null || result == true) return;
        
        if(node.val == t.val){
            result = isSame(node,t);
        }
        
        traverse(node.left,t);
        traverse(node.right,t);
        
    }
    
    private boolean isSame(TreeNode n1, TreeNode n2){
        
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null || n1.val != n2.val) return false;
        
        return isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
    }
}
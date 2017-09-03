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
    public boolean isValidBST(TreeNode root) {
        
        return traverse(root,Long.MAX_VALUE, Long.MIN_VALUE);
        
    }
    
    private boolean traverse(TreeNode root, long upperB, long lowerB){
        
        if(root == null){
            return true;
        }
        
        if(!(root.val < upperB && root.val > lowerB)){
            return false;  
        }
        
        return traverse(root.left, root.val,lowerB) &&
               traverse(root.right, upperB,root.val);    
        
    }
    
}
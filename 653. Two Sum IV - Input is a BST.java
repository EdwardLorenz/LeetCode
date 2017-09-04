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
     List<Integer> nums = new LinkedList();
    
    public boolean findTarget(TreeNode root, int k) {
       
        inorderTraverse(root);
        
        Integer[] array = new Integer[nums.size()];
        nums.toArray(array);
        
        int lo = 0, hi = nums.size() - 1;
        
        while(lo < hi){
            
            int sum = array[lo] + array[hi];
            if(sum == k) return true;
            else if(sum < k){
                lo ++;
            }else{
                hi --;
            }
            
        }
        return false;
        
    }
    
    private void inorderTraverse(TreeNode node){
        if(node == null) return;
        
        inorderTraverse(node.left);
        nums.add(node.val);
        inorderTraverse(node.right);
        
    }
}
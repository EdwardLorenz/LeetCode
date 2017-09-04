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
    public int sumOfLeftLeaves(TreeNode root) {
        return travel(root, false);
    }
    
    public int travel(TreeNode root, boolean isLeft){
        if(root == null) return 0;
        if(root.left == null && root.right == null && isLeft) return root.val;
        else return travel(root.left, true) + travel(root.right, false);
    }
}
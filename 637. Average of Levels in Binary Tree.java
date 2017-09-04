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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> result = new LinkedList();
        
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int n = queue.size();
            long sum = 0;
            
            for(int i = 0; i < n ; i ++){
                TreeNode node = queue.poll();
                sum += node.val;
                
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(sum /(double)n);
        }
        return result;
    }
}
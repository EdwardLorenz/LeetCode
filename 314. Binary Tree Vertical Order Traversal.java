/*

1st thought-DFS: recruisive, but can't gurantee from up -> bottom, because DFS is from left - >right

Therefore : BFS
Two queue : 

*/

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
        
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        Map<Integer,List<Integer>> result = new HashMap<>();
        List<List<Integer>> output = new LinkedList<>();
        
        if(root == null) return output;
        
        int min = Integer.MAX_VALUE;
        
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        
        nodeQueue.offer(root);
        levelQueue.offer(0);
        
        while(!nodeQueue.isEmpty()){
            
            TreeNode node = nodeQueue.poll();
            int level = levelQueue.poll();
            
            // add to result
            List<Integer> list = result.getOrDefault(level, new LinkedList<>());
            list.add(node.val);
            result.put(level,list);
            
            // update min
            if(level < min){
                min = level;
            }
            
            // offer 
            if(node.left != null){
                nodeQueue.offer(node.left);
                levelQueue.offer(level - 1);
            }
            
            if(node.right != null){
                nodeQueue.offer(node.right);
                levelQueue.offer(level + 1);
            }
            
        }
        
        // output
        
        for(int i = min; i < min + result.size(); i ++){
            output.add(result.get(i));
        }
        return output;
        
        
    }
}
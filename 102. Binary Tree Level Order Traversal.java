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
    
    Map<Integer,List<Integer>> result = new HashMap<>();
    int min = Integer.MAX_VALUE;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        
        traverse(root,0);
        
        return new LinkedList<List<Integer>>(result.values());
    }
    
    private void traverse(TreeNode node, int level){
        
        if(level < min){
            min = level;
        }
        
        List<Integer> list = result.getOrDefault(level,new LinkedList<>());
        list.add(node.val);
        result.put(level,list);
        
        if(node.left != null){
            traverse(node.left, level + 1);
        }
        
        if(node.right != null){
            traverse(node.right,level + 1);
        }
        
    }
}
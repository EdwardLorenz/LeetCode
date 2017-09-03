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
    
    List<String> result = new LinkedList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return result;
        
        traverse(root,"");
        return result;
    }
    
    private void traverse(TreeNode root,String path){
        
        if(root == null) return;
        
        String newPath = path + "->" + Integer.toString(root.val);
        
        if(root.left == null && root.right == null){
            String resStr = newPath.substring(newPath.indexOf(">") + 1,newPath.length());
            result.add(resStr);
            return;
        }
        

        traverse(root.left, newPath);
        
        
        traverse(root.right, newPath);
        
        
    }
}
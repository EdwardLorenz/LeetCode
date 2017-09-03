/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
        
    }
    private void buildString(TreeNode root, StringBuilder sb){
        if(root == null) {sb.append("# "); return;}
        
        sb.append( Integer.toString(root.val) + " ");// Add current
        buildString(root.left,sb);
        buildString(root.right,sb);
        
    }
    
   // int curPos = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Queue<String> q = new LinkedList(Arrays.asList(data.split(" ")));

        return parseString(q);
            
    }
    
    private TreeNode parseString(Queue<String> q){
        String cur = q.remove();
        
        if(cur.equals("#")) return null;
        
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = parseString(q);
        node.right = parseString(q);
        
        return node;
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
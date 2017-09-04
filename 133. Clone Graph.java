/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    Map<Integer,UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null) return null;
        
        if(map.containsKey(node.label)){// has copied
            return map.get(node.label);
        }
        
        // has not been copied
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label,newNode);
        
        // copy neighbours
        for(UndirectedGraphNode n : node.neighbors){
            newNode.neighbors.add(cloneGraph(n));
        }
        
        return newNode;
        
    }
}
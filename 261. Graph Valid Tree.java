class Solution {
    int[] source;
    public boolean validTree(int n, int[][] edges) {
        
        if(n  - 1 != edges.length ) return false;
        
        source = new int[n];
        Arrays.fill(source, -1);
        
        for(int[] edge : edges){
            int start = edge[0], end = edge[1];
            
            int source1 = find(start);
            int source2 = find(end);
            
            if(source1 == source2) return false;// loop detected
            
            source[source1] = source2;
            
        }
        return n  - 1 == edges.length ;
        
    }
    
    // find the source of the set
    private int find(int i){
        if(source[i] == -1){
            return i;
        }else{
            return find(source[i]);
        }
    }
}
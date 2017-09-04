class Solution {
    
    Map<Integer,Integer> map = new HashMap();
    
    public int leastBricks(List<List<Integer>> wall) {
        int res = 0;
        for(List<Integer> level : wall){
            int crack = 0;
            for(int i = 0; i < level.size() - 1; i ++){
                crack += level.get(i);
                
                int cnt = map.getOrDefault(crack,0);
                cnt++;
                
                res = Math.max(cnt,res);
                map.put(crack,cnt); 
            }
            
        }
        
        
        return wall.size() - res;
        
    }
}
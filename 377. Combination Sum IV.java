class Solution {
    
    Map<Integer,Integer> map = new HashMap<>();
    
     public int combinationSum4(int[] nums, int target) {
         int[] comb = new int[target + 1];// comb[i] contains ways to add up to i
         comb[0] = 1;// select nothing
         
         for(int i = 0; i < comb.length; i ++){// fill in each blank space in array, from left - > right
             for(int j = 0; j < nums.length; j ++){
                 if( i >= nums[j]){
                     comb[i] += comb[i -  nums[j]];
                 }
                 
             }
         }

         return comb[target];
     }
    
    public int combinationSum42(int[] nums, int target) {
     
        if(target < 0) return 0;
        if(target == 0) return 1;
        
        if(map.containsKey(target)) return map.get(target);
        
        int cnt = 0;
        for(int i = 0; i < nums.length; i ++){
            cnt += combinationSum4(nums, target - nums[i]);
        }
        
        map.put(target,cnt);
        return cnt;
    }
}
class Solution {
    
    Map<Integer,Integer> map = new HashMap();
    
    public boolean checkSubarraySum(int[] nums, int k) {
        
        map.put(0,-1);
        
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            
            // if k == 0, the only siutation return ture is that there exist 00 or more 0s
            // in this case, the alrotihm is seeking a subarray with sum 0 && length >= 2
            int remainder = k !=0 ? sum % k : sum;
        
            Integer startPos = map.get(remainder);
            
            // find a subarray with sum of multiple k && len >= 2
            if(startPos != null && i - startPos >= 2) return true;
            
            if(startPos == null) map.put(remainder,i);
        }
        return false;
    }
}
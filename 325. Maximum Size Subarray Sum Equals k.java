class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        Map<Integer,Integer> sumMap = new HashMap<>();
        int sum = 0;
        int result = 0;
        
        for(int i = 0; i < nums.length; i ++){
            
            sum += nums[i];
            
            if(sum == k){
                result = i + 1;
            }else if(sumMap.containsKey(sum - k)){
                result = Math.max(result, i - sumMap.get(sum - k));
            }
            
           if(!sumMap.containsKey(sum)){
                sumMap.put(sum,i);
            }
            
        }
        
        return result;
        
        
    }
}
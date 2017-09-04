class Solution {
    public int findMaxLength(int[] nums) {
        
        int sum = 0;
        Map<Integer,Integer> sumMap = new HashMap<>();
        int result = 0;
        
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 0){
                sum ++;
            }else if(nums[i] == 1){
                sum --;
            }
            
            if(sum == 0){
                result = i+1;
            }else if(sumMap.containsKey(sum)){
                result = Math.max(result,i - sumMap.get(sum));
            }
            
            if(!sumMap.containsKey(sum)){
                sumMap.put(sum,i);
            }
            
        }
        return result;
    }
}
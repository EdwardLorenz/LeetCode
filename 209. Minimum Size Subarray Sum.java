class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int start = 0;
        int result = nums.length;
        boolean found = false;
        
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            if(sum >= s){
                found = true;
                while(sum - nums[start] >= s){
                sum = sum - nums[start];
                start ++;
                }
                result = Math.min(result, i - start + 1);
            }
                    
        }
        return found?result:0;
    }
}
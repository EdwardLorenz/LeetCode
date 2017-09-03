class Solution {
    public void moveZeroes(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return;
        }
        
        int nonZeroCnt = 0;
        
        // round 1: non 0s
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != 0){
                nums[nonZeroCnt] = nums[i];
                nonZeroCnt ++;
            }
        }
        
        // round 2: 0s
        for(int i = nonZeroCnt; i < nums.length; i ++){
            nums[i] = 0;
        }
        
    }
}
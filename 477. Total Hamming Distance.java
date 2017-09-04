class Solution {
  
    public int totalHammingDistance(int[] nums) {
        int res = 0, total = nums.length;
        
        for(int i = 0 ; i < 32; i ++){
            int bitCnt = 0;
            
             for(int num : nums){
                 bitCnt += (num >> i) & 1;
             }
             
            res += (total - bitCnt) * bitCnt;
        }
        
        return res;
        
    }
}
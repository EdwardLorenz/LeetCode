class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int x: nums) sum+= x;
        if(sum < S || S < -sum) return 0;
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for(int i = 0; i < nums.length; i++){
            int[] next = new int[2 * sum + 1];
            for(int k = 0; k < 2 * sum + 1; k++){
                if(dp[k] != 0){
                    next[k - nums[i]] += dp[k];
                    next[k + nums[i]] += dp[k];
                }
                    
            }
            dp = next;
        }
        return dp[S + sum];
    
    }
}
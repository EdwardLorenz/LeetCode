class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int maxSum = 0;
        
        for(int i = 1; i < prices.length ; i ++){
            sum = Math.max(0,sum + prices[i] -  prices[i - 1]);
            maxSum = Math.max(maxSum,sum); 
        }
        
        return maxSum;
    }
}
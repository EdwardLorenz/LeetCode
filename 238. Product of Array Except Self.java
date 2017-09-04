class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length, mul = 1; 
        int[] res = new int[n];
        
        // product of all elements after itself
        for(int i = 0; i < n ; i ++ ){
            res[i] = mul;
            mul = mul * nums[i];
        }
        
        //produc of all elements before itself
        mul = 1;
        for(int i = n -1; i >=0 ; i --){
            res[i] = res[i] * mul;
            mul = mul * nums[i];
        }
        return res;
    }
}
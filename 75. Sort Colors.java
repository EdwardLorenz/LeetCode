class Solution {
    
    int[] numsArray;
    
    public void sortColors(int[] nums) {
        
        numsArray = nums;
        
        int zeroPtr = 0;
        int twoPtr = nums.length - 1;
        
        for(int i = 0; i <= twoPtr; i ++){
            
            while(nums[i] == 2 && i< twoPtr){
                swap(twoPtr --, i);
            }
            
            while(nums[i] == 0 && i > zeroPtr){
                swap(zeroPtr ++, i);
            }
            
        }
        
    }
    
    private void swap(int x, int y){
        
        int temp = numsArray[x];
        
        numsArray[x] = numsArray[y];
        numsArray[y] = temp;
    }
}
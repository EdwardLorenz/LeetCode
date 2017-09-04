class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        
        for(int i = 1 ; i < nums.length; i ++){
            //System.out.println(index);
            
            if(nums[i] !=  nums[index-1]){
                nums[index++] = nums[i];
                
            }
            
        }
        
        return index;
        
    }
}
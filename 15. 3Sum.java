class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new LinkedList<>();
        
        if(nums == null || nums.length < 3) return result;
        
        Arrays.sort(nums);

        for(int i = 0; i < nums.length ; i ++){
            if( i != 0 && nums[i] == nums[i - 1]) continue;
            
            // two sum
            int target = -1 * nums[i];
            int start = i + 1, end = nums.length - 1;
            
           
            // add two numbers
            while(start < end){
             
                if(nums[start] + nums[end] == target){
                    
                    result.add(new LinkedList<Integer>(Arrays.asList(nums[i],nums[start],nums[end])));
                    // remove duplicates
                    while(start < end && nums[start + 1] == nums[start]) start ++;
                    while(start < end && nums[end - 1] == nums[end]) end --;
                    
                    // move pointer
                    start ++;
                    end --;
                    
                }else if(nums[start] + nums[end] > target){
                    end --;
                }else{
                    start ++;
                }
                
            } 
            
        }
        return result;
    }
}
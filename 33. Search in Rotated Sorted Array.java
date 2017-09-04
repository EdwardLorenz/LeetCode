class Solution {
    int pivot;
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return -1;
        
        pivot = findPivot(nums);
        //binary search
        int lo = 0,hi = nums.length - 1;
        
        while(lo <= hi){
            int current = lo - (lo - hi)/2;
            int value = get(nums,current);
            if(value < target){
                lo = current + 1;
            }else if(value > target){
                hi = current - 1;
            }else{
                return (current + pivot) % nums.length;
            }
        }
        
        return -1;
    }
    
    private int get(int[] nums, int index){
        return nums[(pivot + index)%nums.length];
        
    }
    
    private int findPivot(int[] nums){
        
        int lo = 0, hi = nums.length - 1;
        
        while(lo < hi){
            int current = lo - (lo - hi)/2;
            if(nums[current] > nums[hi]){// pivot is in right
                lo = current + 1;
            }else{// pivot is in left
                hi = current;
            }
        }
        
        return lo;
    }
}
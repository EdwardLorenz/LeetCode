class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int lo = 0;
        int hi = nums.length - 1;
        int pivot = 0, loc = nums.length - k;
        while(true){
            pivot = partition(nums, lo, hi);
            if(pivot == loc) break;
            if(pivot < loc){
                lo = pivot + 1;
            }else{
                hi = pivot - 1;
            }
        }
        return nums[loc];
    }
    
    private int partition(int[] nums, int lo, int hi){
        
        int pivot = nums[lo];
        while(lo < hi){
            // find one element in the right part && less than pivot
            while(lo < hi && nums[hi] >= pivot) hi --;
            nums[lo] = nums[hi];
            // find one element in the left part && larger than pivot
            while(lo < hi && nums[lo] <= pivot) lo ++;
            nums[hi] = nums[lo];   
        }
        
        nums[lo] = pivot;
        return lo;
        
    }
}
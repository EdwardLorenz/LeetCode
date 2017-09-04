class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int e1 = Integer.MAX_VALUE, e2 = Integer.MAX_VALUE;
        
        for(int i : nums){
            if(i <= e1){// smallest element
                e1 = i;
            }else if(i <= e2){// second smallest element
                e2 = i;
            }else if( i > e2){
                return true;
            }
        }
        return false;
    }
}
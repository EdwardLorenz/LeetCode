class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int i = m + n - 1;
        for(;ptr1 >= 0 && ptr2 >= 0 && i >= 0 ; i --){
            if(nums1[ptr1] > nums2[ptr2]){// move 1
                nums1[i] = nums1[ptr1 --];
            }else{// move 2
                nums1[i] = nums2[ptr2 --];
            }
        }
        
        while(ptr2 >= 0){
             nums1[i--] = nums2[ptr2--];
        }
    }
}
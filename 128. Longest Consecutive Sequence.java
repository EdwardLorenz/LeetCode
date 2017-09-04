class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        int res = 0;
        for(int num : nums){
            
            if(map.containsKey(num)) continue;
            
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            
            int newLen = left + right + 1;
            
            res = Math.max(res,newLen);
            
            // Put num as key
            map.put(num,newLen);
            
            //update left and right
            map.put(num - left,newLen);
            map.put(num + right,newLen);
        }
        return res;
    }
}
class Solution {
    List<List<Integer>> result = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        //Arrays.sort(nums);
        
        backtrack(nums,0,new LinkedList<>());
        
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> list){
        result.add(new LinkedList<>(list));
        
        for(int i = start; i < nums.length; i ++){
            list.add(nums[i]);
            backtrack(nums,i + 1,list);
            list.remove(list.size() - 1);
        }
        
        
    }
}
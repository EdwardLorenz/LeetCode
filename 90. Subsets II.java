class Solution {
    List<List<Integer>> result = new LinkedList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        
        DFS(nums,0, new LinkedList());
        
        return result;
    }
    
    private void DFS(int[] nums, int start, List<Integer> list){
        
       result.add(new LinkedList(list));
        
        for(int i = start; i < nums.length; i ++){
            list.add(nums[i]);
            DFS(nums,i + 1, list);
            list.remove(list.size() - 1);
            while(i < nums.length - 1 && nums[i] == nums[i+1]) i ++;// skip duplicated  
        }
        
    }
}
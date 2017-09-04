class Solution {
    
    Map<String,List<String>> map = new HashMap<>();
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        
        if(strs == null || strs.length == 0) return res;
        
        // put anagrams into same list
        for(String str : strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            
            List<String> list = map.getOrDefault(key, new LinkedList<>());
            list.add(str);
            map.put(key,list);
        }
        
        // get all anagrams lists
        for(Map.Entry<String,List<String>> e : map.entrySet()){
            res.add(e.getValue());
        }
        
        return res;
        
    }
}
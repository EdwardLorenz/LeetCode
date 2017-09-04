class Solution {
    Set<char []> ruleSet;
    
    Map<Character,Integer> cntMap = new HashMap();// <char, how many prerequisite char has>(right)
    Map<Character,List<Character>> prerequisiteMap = new HashMap();// <char, list has char as prerequisite>(left)
    Set<Character> vocabulary = new HashSet();
    
    StringBuilder res = new StringBuilder();
    
    public String alienOrder(String[] words) {
        ruleSet = generateRule(words);
        initateTopology();
        boolean sortable = topologySort(words);
        
        return sortable ? res.toString() : "";
    }
    
    private void initateTopology(){
        
        for(char[] rule : ruleSet){// 0 : pre char, 1 : next char; pre - > next
            List<Character> list = prerequisiteMap.getOrDefault(rule[0], new LinkedList());
            list.add(rule[1]);
            prerequisiteMap.put(rule[0], list);
            
            cntMap.put(rule[1],cntMap.getOrDefault(rule[1],0) + 1);
        }
        
    }
    
    private boolean topologySort(String[] words){
        
        Queue<Character> queue = new LinkedList();
        
        // find chars with node pre
        for(Character c : vocabulary){
            if(!cntMap.containsKey(c)){
                queue.offer(c);
            }
        }
        
        while(!queue.isEmpty()){
            char c = queue.poll();
            res.append(c);// Add to result
            
            List<Character> list = prerequisiteMap.getOrDefault(c,new LinkedList());
            
            for(Character ch : list){
                int cnt = cntMap.get(ch);
                cnt --;
                if(cnt == 0){// find one char with no pre
                    queue.offer(ch);
                    cntMap.remove(ch);
                }else{
                    cntMap.put(ch,cnt);
                }
            }
            
        }
         return cntMap.isEmpty();
    }
    
    private Set<char[]> generateRule(String[] words){
        
        Set<char []> set = new HashSet();
        
        // enlarge vocabulary
   
        for(char c : words[0].toCharArray()){
            vocabulary.add(c);
        }
        
        for(int i = 1 ; i < words.length; i ++){
            
            // rules in the same word
            int diff = findFirstDifferentLetter(words[i],words[i - 1]);
            
            // enlarge vocabulary    
            for(char c : words[i].substring(diff,words[i].length()).toCharArray()){
            vocabulary.add(c);
            }
        
            if(diff != Math.min(words[i].length(), words[i - 1].length())){
                set.add(new char[]{words[i - 1].charAt(diff), words[i].charAt(diff)});
            }
            
        }
        return set;
        
    } 
    
    private int findFirstDifferentLetter(String s, String t){
        
        int i = 0;
        
        for(; i < Math.min(s.length(), t.length()) ; i ++){
            if(s.charAt(i) != t.charAt(i)) return i;
        }
        
        return i;
    }
}
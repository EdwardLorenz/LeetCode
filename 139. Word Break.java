class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] breakArray = new boolean[s.length() + 1];
        breakArray[0] = true;
        
        for(int i = 0; i < s.length(); i ++){
            for(int j = 0; j <= i; j ++){
                if(breakArray[j]&& wordDict.contains(s.substring(j,i + 1))){
                    breakArray[i+1] = true;
                    break;
                }
                
            }
            
        }
        
        return breakArray[s.length()];
        
    }
}

/*
    public boolean wordBreak(String s, List<String> wordDict) {
                   
        if(s.length() == 0) return true;
        
        for(int i = 0; i < s.length(); i ++){
            if(wordDict.contains(s.substring(0,i + 1)) && 
               wordBreak(s.substring(i + 1,s.length()),wordDict)){
                return true;
            }
        }
        
        return false;
        
    }

*/
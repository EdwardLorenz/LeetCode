class Solution {
    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        
        // initiate
        for(char c: t.toCharArray()){
            cnt[c] ++;
        }
        
        int start = 0,end = 0,minLen = Integer.MAX_VALUE, minStart = 0,counter = t.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        while(end < sChars.length){
            
            if(cnt[sChars[end]] > 0){// find a char in t
                counter --;
            }
            
            cnt[sChars[end++]]--;// move end ptr forward
            
            while(counter == 0){
                // update min length
                if(end - start <  minLen){
                    minLen = end - start;
                    minStart = start;
                }
                
                //forward start ptr, make it invalid
                if(cnt[sChars[start]] == 0){// start ptr move over one char in t
                    counter ++;// more to match   
                }
     
               cnt[sChars[start++]] ++;
                
            }  
       
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart + minLen);
    }
}

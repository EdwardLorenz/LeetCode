/*

O(n)
*/

class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int[] ways = new int[s.length()];
        
        
        for(int i = 0; i < s.length() ; i ++){
            
            if(i >= 1 && isLetter(s,i - 1, i + 1)){// 2digits
                ways[i] += i >= 2 ? ways[i - 2] : 1;
            }
            
            if(s.charAt(i) != '0'){// 1 digits
                ways[i] += i >= 1 ? ways[i - 1] : 1;
            } 
        }
        
        return ways[s.length() - 1];
        
    }
    
    private boolean isLetter(String s, int start, int end){
        
        String numStr = s.substring(start,end);
        int num = Integer.valueOf(numStr);
        
        if(num >= 10 && num <= 26){
            return true;
        }else{
            return false;
        }
        
    }
}
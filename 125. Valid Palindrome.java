class Solution {
    public boolean isPalindrome(String s) {
        
        int lo = 0;
        int hi = s.length() - 1;
        char[] chs = s.toCharArray();
        
        while(lo < hi){
            
            while(lo < hi && !Character.isLetterOrDigit(chs[lo])) lo ++;
            while(lo < hi && !Character.isLetterOrDigit(chs[hi])) hi --;
            
            if(!(Character.toLowerCase(chs[lo]) == Character.toLowerCase(chs[hi]))) {
                return false;
            }
                
            lo ++;
            hi --;
            
        }
        
        return true;
        
    }
}
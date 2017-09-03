class Solution {
    /* 
    
    If s.charAt(i) == p.charAt(j) ->  dp[i][j] = dp[i - 1][j - 1]
    If p.charAt(j) == '.'         ->  dp[i][j] = dp[i - 1][j - 1] 
    If p.charAt(j) == '*'
        1. s.charAt(i) != p.charAt(j - 1) -> s.charAt(i) != p.charAt(j)
            aaaaa
            aaab*
            
            dp[i][j] = dp[i][j-2]
        2.s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1)  == '.'
            ????a
            ???a*
            
            a) a* = a     -> dp[i][j] = dp[i][j-1]
            b) a* = aa..a -> dp[i][j] = dp[i-1][j]
            c) a* = ""    -> dp[i][j] = dp[i][j-2]
        
        
    */
    public boolean isMatch(String s, String p) {
        
        if (s == null || p == null) {
        return false;
        }
     
        // dp[i][j] :  whether s[i - 1] and p[j - 1] match
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        dp[0][0] = true;
        
        /* init
           prefix: a*b*c*
        */
        for(int i = 0; i < p.length(); i ++){
            if(p.charAt(i) == '*' && dp[0][i - 1]){
                dp[0][i+1] = true;
            }
        }
        
        // dp
        for(int i =0; i < s.length(); i ++){
            for(int j = 0; j < p.length(); j ++){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j) == '*'){
                    if(p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.'){
                        dp[i+1][j+1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    }else{
                         dp[i+1][j+1] = dp[i + 1][j - 1];
                    }
                    
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}
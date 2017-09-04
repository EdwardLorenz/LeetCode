class Solution {
    
    // dp[i] = ways(i) * dp[i -1] + ways(i,i - 1) * dp[i = 2]
    public int numDecodings(String s) {
        
        long dp[] = new long[s.length()];
        
        char[] chs = s.toCharArray();
        for(int i = 0; i < s.length(); i ++){
            dp[i] +=(i < 1 ? 1 : dp[i - 1] )* way(chs[i]);
            
            dp[i] += ( i < 2 ? 1 : dp[i - 2]) * ( i < 1 ? 0: ways(chs[i - 1],chs[i]));
            
            dp[i] %=  1000000007; 
            //System.out.println("dp " + i + " = " + dp[i]);
        }
        
        return (int)dp[s.length() - 1];
        
    }
    
    private int way(char i){
        if(i == '0'){
            return 0;
        }else if(i == '*'){
            return 9;
        }else{
            return 1;
        }
    }
    
    private int ways(char i, char j){
        
        if(i != '*' && j != '*'){
            String numStr = new String(new char[]{i,j});
            int num = Integer.valueOf(numStr);
            if(num >= 10 && num <=26 ) return 1;
            
        }else if(i != '*' && j == '*'){ // 1*; 2*
            if(i =='1'){
            return 9;
            }else if(i == '2'){
            return 6;}
                
        }else if(i == '*' && j == '*'){
                return 15;
                
        }else{
                if(j - '0' >= 0 && j - '0' <= 6 ){
                    return 2;
                }else{
                    return 1;
                }
            }
        
        return 0;
    }
    
}
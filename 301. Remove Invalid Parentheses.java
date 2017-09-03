/*

O(nk): n is input length, k is number of result

OR

O(nm): m is number of recursive call
*/

class Solution {
    
    List<String> result = new LinkedList();
    public List<String> removeInvalidParentheses(String s) {
      if(s == null) return result;
        
      remove(s,0,0, new char[]{'(',')'});
      return result;
        
    }
    // DFS
    private void remove(String s, int index, int lastDeletePos, char[] pair){
        char[] chs = s.toCharArray();
        int stack = 0;
        
        for(int i = index; i < chs.length; i ++){
            
            if(chs[i] == pair[0]) stack ++;
            else if(chs[i] == pair[1]) stack --;
   
            if(stack >= 0) continue;
            
            //there is one more ')', seek delete pos
            for(int j = lastDeletePos; j <= i; j ++){
                if(chs[j] == pair[1] && (j == lastDeletePos || chs[j - 1] != pair[1])){
                    // if there are consequtive ')', always choose 1st
                    remove(s.substring(0,j) + s.substring(j + 1,chs.length), i, j, pair);
                }   
            }
            return;
        }
        
        
        //reverse
        String reverse = new StringBuilder(s).reverse().toString();
   
        if(chs.length > 0 && pair[0] == '('){
            remove(reverse,0,0, new char[]{')','('});
        }else{
            result.add(reverse);
        }
        
    }
}
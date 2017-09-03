/*

O(4^n) : each digit : +, -, *, ""
*/

class Solution {
    List<String> res = new LinkedList();
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) return res;
        backtracking(num,target,0,0,0,"");
        return res;
    }
    
    private void backtracking(String num, int target, int pos, long lastNum, long curSum, String path){
        
        if(pos == num.length() && curSum == target){
            res.add(path);
            return;
        }
        
        for(int i = pos; i < num.length(); i ++){
            // when start with 0, consider only one char'0', ignore cases like '0..n'
            if(i != pos && num.charAt(pos) == '0') break;
            
            long cur = Long.valueOf(num.substring(pos, i + 1));
            
            if(pos == 0){
                 backtracking(num,target,i + 1,cur,cur,path + cur);// first num
            }else{
            backtracking(num,target,i + 1,cur,curSum + cur,path + "+" + cur);// +
            backtracking(num,target,i + 1,-cur,curSum - cur,path + "-" +cur);// -
            backtracking(num,target,i + 1,cur * lastNum,curSum - lastNum + cur * lastNum, path + "*" +cur);// *
            }
            
        }
        
        
    }
}
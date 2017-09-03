class Solution {
    
    String[] letters = new String[] {"0", "1", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        if(digits == null ||digits.length() == 0){
            return new LinkedList<>();
        }
        
        Queue<String> queue = new LinkedList<>();
        
        queue.offer("");
        
        for(int i = 0; i < digits.length(); i ++){
            int  num = digits.charAt(i) - '0';
            
            while(queue.peek().length() == i){
                String str = queue.poll();
                for(int j = 0; j < letters[num].length(); j++){
                    queue.offer(str + letters[num].charAt(j));
                }
            } 
            
        }
        
        return new LinkedList<String>(queue);
        
    }
}
class Solution {
    public String countAndSay(int n) {
    
        
        String currentStr = "1";
        while(-- n > 0){
            currentStr = generate(currentStr);
        }
        return currentStr;
        
    }
    
    private String generate(String str){
        if(str.length() == 1)
            return 1 + str;
        
        // split str into chuncks with same letter
        // e.g.: 111221 - > "111" "22" "1"
        
        StringBuilder result =  new StringBuilder();
        int cnt = 0;
        char last = '0';
        for(char c : str.toCharArray()){
            
            if(last != c){
                //generate
                // e.g. "111" -> "31" cnt  + char
                if(cnt != 0) result.append(Integer.toString(cnt) + last);
                last = c;
                cnt = 1;      
            }else{
                cnt ++;
            }
            
        }
        
        result.append(Integer.toString(cnt) + last);
        
        return result.toString();
        
        
    }
}
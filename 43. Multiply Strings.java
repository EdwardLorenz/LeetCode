class Solution {
    public String multiply(String num1, String num2) {
        
        int l1 = num1.length();
        int l2 = num2.length();
        
        int[] res = new int[l1 + l2];
        
        for(int i = l1 - 1; i >= 0; i --){
            for(int j = l2 - 1; j >= 0; j --){
               
                int product = (num1.charAt(i) - '0') *  (num2.charAt(j) - '0');
                int pos1 = i + j, pos2 = i + j + 1;
                
                product += res[pos2];
                
                res[pos1] += product / 10; 
                res[pos2] = product % 10; 
            
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : res){
            
            if(sb.length() == 0 && i == 0) continue;
            sb.append(i);
        }
        
        return sb.toString().length() == 0? "0" : sb.toString();
        
    }
}
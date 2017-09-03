/*

O(log n) =  O(log 1000 ^n)
*/

class Solution {
    
    // 0 -19
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    
    public String numberToWords(int num) {
        
        if(num == 0) return "Zero";
        
        int i = 0;
        String res = "";
        
        while(num > 0){
            
            if(num % 1000 != 0){
                res = generater(num % 1000) + THOUSANDS[i] + " " + res;
            }
            
            num = num/1000;
            i ++;
        }
        return res.trim();
    }
    
    // process number less than 1000
    private String generater(int num){
        
        if(num == 0){
            return "";
        }else if (num < 20){
            return LESS_THAN_20[num] + " ";
        }else if (num < 100){
            return TENS[num/10] + " " + generater(num%10);
        }else{
            return LESS_THAN_20[num/100] + " Hundred " + generater(num%100);
        }
        
    }
}
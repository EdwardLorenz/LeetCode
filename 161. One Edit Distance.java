class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        int diff = s.length() - t.length();
        if(Math.abs(diff) > 1) return false;
        
        if(diff > 0) return isOneEditDistance(t,s);// maks sure the first one is shortter
        
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) != t.charAt(i)){
                if(diff == 0){// replace one
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }else{// delete one
                    return s.substring(i).equals(t.substring(i + 1));
                }    
            }
        }
        
        // last one is different
        return diff == - 1;
        
    }
}
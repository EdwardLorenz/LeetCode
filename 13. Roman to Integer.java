class Solution {
    
    Map<Character, Integer> map = new HashMap();
    public int romanToInt(String s) {
        initMap();
        int res = 0, last = 0;
        for(char c: s.toCharArray()){
            int value = map.get(c);
            
            res += value;
            if(last < value){
                res -= last * 2;
            }
            
            last = value;// keep track of last value
        }
        return res;
    }
    
    private void initMap(){
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
}
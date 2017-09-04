class Solution {
    public int hIndex(int[] citations) {
        
        /*
            bucked sort: time : O(n) space O(n)
        */
        int[] buckets = new int[citations.length + 1];
        
        // bucket sort
        for(int c : citations){
            if(c > citations.length){
                buckets[citations.length] ++;
            }else{
                buckets[c] ++;
            }
        }
        
        //cnt
        int cnt = 0;
        for(int i = citations.length;i >= 0; i -- ){
            cnt += buckets[i];
            if(cnt >= i){
                return i;
            }
        }
        return 0;
    }
    
    /*
        Sort and go through : O(nlogn) , in place
    */
    
    // case 1: find one citations[i] < hInde : return hIndex - 1
    // case 2: fina no citations[i] < hInde : return hIndex
    public int hIndex2(int[] citations) {
        if(citations == null ||citations.length == 0) return 0;
        
        Arrays.sort(citations);
        
        int hIndex = 0;
        for(int i = citations.length - 1; i >= 0; i--){
            hIndex = citations.length - i;
            if(citations[i] < hIndex) {
                hIndex --;
                break;
            }
        }
        
        return hIndex;
    }
}
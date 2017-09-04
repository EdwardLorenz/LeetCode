class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len - 1;

        while(lo <= hi){
            
            int mid = lo - (lo - hi)/2;// mid = (lo + hi)/2
            
            if(citations[mid] == len - mid){
                return len - mid;
            }else if(citations[mid] > len - mid){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
            
        }
        return len - hi - 1;// hi is the first that not satisfy constain
    }
}
class Solution {
    public int mySqrt(int x) {
     
        long r = x;
        
        while(r * r > x){
            r = (r + x/r)/2;// r is larger than sqrt(x), while x/r is less than sqrt(x)
        }
        
        return (int)r;
    }
}
class Solution {
    public double myPow(double x, int n) {
        
        long nlong = n;
        if(nlong == 0){
            return 1;
        }else if(nlong < 0 ){
            nlong = -nlong;
            System.out.println(nlong);
            return  1/pow(x, nlong);
        }else{
            return pow(x, nlong);
        }
    }
    
    private double pow(double x, long n) {
        
        if(n == 1) return x;
        
        if(n % 2 == 0){// even
            double res = pow(x,n/2);
            return res * res;
        }else{// odd
            return x * pow(x,n - 1);
        }
    }
    
}
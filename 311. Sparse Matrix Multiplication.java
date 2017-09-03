class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
     
        int[][] result = new int[A.length][B[0].length];
        
        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < A[0].length; j ++){
                
                if(A[i][j] != 0){
                    
                    for(int k = 0; k < B[0].length; k ++){
                        if(B[j][k] != 0){
                            result[i][k] += A[i][j] * B[j][k];
                        }
                    }
                    
                }
                
                
            }
        }
        return result;
    }
}
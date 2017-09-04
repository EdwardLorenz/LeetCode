class Solution {
    String target;
    char[][] grid;
    
    int row;
    int col;
    
    public boolean exist(char[][] board, String word) {
        target = word;
        grid = board;
        
        row = board.length;
        col = board[0].length;
        
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(grid[i][j] == word.charAt(0) && search(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    

    private boolean search(int i, int j,int index){
        
        if( i < 0 || j < 0 || i >= row || j >= col) return false;
        
        if(grid[i][j] != target.charAt(index)) return false;
        
        if(index == target.length() - 1) return true;
        
        grid[i][j] ^= 256;
        
        boolean res =  search(i + 1, j, index + 1) ||
               search(i, j + 1, index + 1) ||
               search(i - 1, j, index + 1) ||
               search(i, j - 1, index + 1);
        
        grid[i][j] ^= 256;
        return res;
        
    }
}
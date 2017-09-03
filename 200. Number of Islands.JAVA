class Solution {
    
    int row;
    int col;
    int result = 0;
    
    public int numIslands(char[][] grid) {
        
        row = grid.length;
        
        if(grid == null || row == 0) return 0;
        
        col = grid[0].length;
        
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(grid[i][j] == '1'){
                    result ++;
                    flooding(i,j, grid);
                }
            }
        }
        
        return result;
    }
    
    private void flooding(int i, int j, char[][] grid){
        
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        
        flooding(i + 1, j, grid);
        flooding(i, j + 1, grid);
        flooding(i - 1, j, grid);
        flooding(i, j - 1, grid);
        
        
    }
}
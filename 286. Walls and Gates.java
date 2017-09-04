class Solution {
    
    /*
    O(mn * k) k is the number of gates, evry element is touched k times
    */
       public void wallsAndGates(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++)
        for (int j = 0; j < rooms[0].length; j++)
            if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
}

private void dfs(int[][] rooms, int i, int j, int d) {
    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
    rooms[i][j] = d;
    dfs(rooms, i - 1, j, d + 1);
    dfs(rooms, i + 1, j, d + 1);
    dfs(rooms, i, j - 1, d + 1);
    dfs(rooms, i, j + 1, d + 1);
}

/*
*  BFS O(mn) evry element is touched only once
*
*/
    int row;
    int col;
    
    public void wallsAndGates2(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        row = rooms.length;
        col = rooms[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // put in all start poins : 0s
        for(int i = 0 ;i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(rooms[i][j] == 0)  queue.offer(new int[] {i,j});
            }
        }
        
        //BFS
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int i = pos[0];
            int j = pos[1];
            
            int dis = rooms[i][j] + 1;
            
            // up
            if(i < row - 1 && rooms[i + 1][j] == Integer.MAX_VALUE) 
            {
                rooms[i + 1][j] = dis;
                queue.offer(new int[] {i + 1,j});
            }
            // down
            if(i > 0 && rooms[i - 1][j] >dis) 
            {
                rooms[i - 1][j] = dis;
                queue.offer(new int[] {i - 1,j});
            }
            // left
            if(j > 0 && rooms[i][j - 1] >dis) 
            {
                rooms[i][j - 1] = dis;
                queue.offer(new int[] {i,j - 1});
            }
            // right
            if(j < col - 1 && rooms[i][j + 1] >dis) 
            {
                rooms[i][j + 1] = dis;
                queue.offer(new int[] {i,j + 1});
            }
               
            
        }
        
    }
       

}
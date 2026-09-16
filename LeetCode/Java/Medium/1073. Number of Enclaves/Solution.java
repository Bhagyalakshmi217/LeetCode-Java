class Solution {
    public int numEnclaves(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int count=0;
        for(int c=0;c<cols;c++){
            dfs(grid,0,c,rows,cols);
        }
        for(int c=0;c<cols;c++){
            dfs(grid,rows-1,c,rows,cols);
        }
        for(int r=0;r<rows;r++){
            dfs(grid,r,0,rows,cols);
        }
        for(int r=0;r<rows;r++){
            dfs(grid,r,cols-1,rows,cols);
        }
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    count++;
                }
            }
        }
    return count;
        
    }
    private void dfs(int[][] grid,int r,int c,int rows,int cols){
        if(r<0||r>=rows||c<0||c>=cols||grid[r][c]==0){
            return;
        }
        grid[r][c]=0;
        dfs(grid,r-1,c,rows,cols);
        dfs(grid,r+1,c,rows,cols);
        dfs(grid,r,c-1,rows,cols);
        dfs(grid,r,c+1,rows,cols);

    }
}
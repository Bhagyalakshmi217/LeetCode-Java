class Solution{
    public int maxAreaOfIsland(int[][] grid){
        int rows=grid.length;
        int cols=grid[0].length;
        int maxArea=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    int area=dfs(grid,r,c,rows,cols);
                    maxArea=Math.max(maxArea,area);
                }
            }        }
            return maxArea;
    }
    private int dfs(int[][] grid,int r,int c,int rows,int cols){
        if(r<0||r>=rows||c<0||c>=cols||grid[r][c]==0){
            return 0;
        }
        grid[r][c]=0;
        int up=dfs(grid,r-1,c,rows,cols);
        int down=dfs(grid,r+1,c,rows,cols);
        int left=dfs(grid,r,c-1,rows,cols);
        int right=dfs(grid,r,c+1,rows,cols);
        return 1+up+down+left+right;
        
    }
}
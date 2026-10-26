class Solution{
    public void solve(char[][] grid){
        int rows=grid.length;
        int cols=grid[0].length;
        for(int c=0;c<cols;c++){
            if(grid[0][c]=='O'){
                dfs(grid,0,c,rows,cols);
            }
        }
            for(int c=0;c<cols;c++){
                if(grid[rows-1][c]=='O'){
                    dfs(grid,rows-1,c,rows,cols);
                }
            }
                for(int r=0;r<rows;r++){
                    if(grid[r][0]=='O'){
                        dfs(grid,r,0,rows,cols);
                    }
                }
                    for(int r=0;r<rows;r++){
                        if(grid[r][cols-1]=='O'){
                            dfs(grid,r,cols-1,rows,cols);
                        }
                    }
                    for(int r=0;r<rows;r++){
                        for(int c=0;c<cols;c++){

                      

                    if(grid[r][c]=='O'){
                        grid[r][c]='X';
                    }
                    else if(grid[r][c]=='S'){
                        grid[r][c]='O';
                    }
                        }
                    }
    }
    
    private void dfs(char[][] grid,int r,int c,int rows,int cols){
        if(r<0||r>=rows||c<0||c>=cols||grid[r][c]!='O'){
            return;
        }
        grid[r][c]='S';
        dfs(grid,r-1,c,rows,cols);
        dfs(grid,r+1,c,rows,cols);
        dfs(grid,r,c-1,rows,cols);
        dfs(grid,r,c+1,rows,cols);
    }
}
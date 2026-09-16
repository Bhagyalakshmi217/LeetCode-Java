// class Solution {
//     public void solve(char[][] board) {
//         int rows=board.length;
//         int cols=board[0].length;
//         for(int i=0;i<rows;i++){
//             if(board[i][0]=='O'){
                // dfs(board,i,0);
//             }
//             if(board[i][cols-1]=='O'){
//                 dfs(board,i,cols-1);
//             }
//         }
//         for(int j=0;j<cols;j++){
//             if(board[0][j]=='O'){
//                 dfs(board,0,j);
//             }
//             if(board[rows-1][j]=='O'){
//                 dfs(board,rows-1,j);
//             }
//         }

//         for(int i=0;i<rows;i++){
//             for(int j=0;j<cols;j++){
//                 if(board[i][j]=='O'){
//                     board[i][j]='X';
//             }   
//                 else if(board[i][j]=='#'){
//                     board[i][j]='O';
//             }
//         }
//         }
        
//     }
//     private void dfs(char[][] board,int r,int c){
        
//         if(r<0 || r>=board.length || c<0 ||c>=board[0].length || board[r][c]!='O'){
//             return;
//         }
//         board[r][c]='#';
//         dfs(board,r-1,c);
//         dfs(board,r+1,c);
//         dfs(board,r,c-1);
//         dfs(board,r,c+1);

        
// }
// }



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
// class Solution {
//     public List<List<Integer>> pacificAtlantic(int[][] heights) {
//         int rows=heights.length;
//         int cols=heights[0].length;

//         boolean[][] pacific=new boolean[rows][cols];
//         boolean[][] atlantic=new boolean[rows][cols];

//         for(int i=0;i<rows;i++){
//             dfs(heights,pacific,i,0);
//         }
//         for(int j=0;j<cols;j++){
//             dfs(heights,pacific,0,j);
//         }

//         for(int i=0;i<rows;i++){
//             dfs(heights,atlantic,i,cols-1);
//         }
//         for(int j=0;j<cols;j++){
//             dfs(heights,atlantic,rows-1,j);
//         }

//         List<List<Integer>> ans=new ArrayList<>();
//         for(int i=0;i<rows;i++){
//             for(int j=0;j<cols;j++){
//                 if(pacific[i][j] && atlantic[i][j]){
//                     ans.add(Arrays.asList(i,j));
//                 }
//             }
//         }
//         return ans;
//     }
//     private void dfs(int[][] heights,boolean[][] visited,int r,int c){
//         visited[r][c]=true;

//         int[][] dir={
//             {-1,0},
//             {1,0},
//             {0,-1},
//             {0,1}
//         };

//         for(int[] d:dir){
//             int nr=r+d[0];
//             int nc=c+d[1];
        
//         if(nr>=0 && nr<heights.length && nc>=0 &&nc<heights[0].length && !visited[nr][nc] && heights[nr][nc]>=heights[r][c]){
//             dfs(heights,visited,nr,nc);
//             }

//         }

        
//     }
// }






class Solution{
    public List<List<Integer>> pacificAtlantic(int[][] grid){
        List<List<Integer>> ans=new ArrayList<>();
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];
        for(int c=0;c<cols;c++){
            dfs(grid,0,c,rows,cols,pacific);
        }
        for(int r=0;r<rows;r++){
            dfs(grid,r,0,rows,cols,pacific);
        }
        for(int c=0;c<cols;c++){
            dfs(grid,rows-1,c,rows,cols,atlantic);
        }
        for(int r=0;r<rows;r++){
            dfs(grid,r,cols-1,rows,cols,atlantic);
        }
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    ans.add(Arrays.asList(r,c));
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] grid,int r,int c,int rows,int cols,boolean[][] visited){
        
        if(r<0||r>=rows||c<0||c>=cols||visited[r][c]==true){
            return;
        }
        visited[r][c]=true;
        

        if(r>0 && grid[r-1][c]>=grid[r][c])
            dfs(grid,r-1,c,rows,cols,visited);
        if(r<rows-1 && grid[r+1][c]>=grid[r][c])
            dfs(grid,r+1,c,rows,cols,visited);
        if(c>0 && grid[r][c-1]>=grid[r][c])
            dfs(grid,r,c-1,rows,cols,visited);
        if(c<cols-1 && grid[r][c+1]>=grid[r][c])
            dfs(grid,r,c+1,rows,cols,visited);
    }
}
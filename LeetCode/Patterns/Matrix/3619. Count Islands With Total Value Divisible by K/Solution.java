class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]!=0){
                    long sum=dfs(grid,r,c);

                    if(sum%k==0){
                        count++;
                    }
                    }
                }
            }
            return count;


        }
    long dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n ||
            grid[r][c] == 0) {
            return 0;
    }

        long value = grid[r][c];
        grid[r][c] = 0;

        long down = dfs(grid, r + 1, c);
        long up = dfs(grid, r - 1, c);
        long right = dfs(grid, r, c + 1);
        long left = dfs(grid, r, c - 1);

        return value + down + up + right + left;
}
        
    }

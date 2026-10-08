// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         if(obstacleGrid[0][0]==1){
//             return 0;
//         }
//         int m=obstacleGrid.length;
//         int n=obstacleGrid[0].length;
//         int[][] dp=new int[m][n];
//         dp[0][0]=1;
//         for(int j=1;j<n;j++){
//             if(obstacleGrid[0][j]==1){
//                 dp[0][j]=0;
//             }else{
//                 dp[0][j]=dp[0][j-1];
//                 }
//             }
//             for(int i=1;i<m;i++){
//                 if(obstacleGrid[i][0]==1){
//                     dp[i][0]=0;
//                 }else{
//                     dp[i][0]=dp[i-1][0];
//                 }
//             }
//             for(int i=1;i<m;i++){
//                 for(int j=1;j<n;j++){
//                     if(obstacleGrid[i][j]==1){
//                         dp[i][j]=0;
//                     }else{
//                         dp[i][j]=dp[i-1][j]+dp[i][j-1];
//                     }
//                 }
//             }
        
//         return dp[m-1][n-1];
        
//     }
// }


class Solution {
    int[][] dp;
    int f(int i,int j,int[][] obstacleGrid){
        if(i<0 || j<0){
            return 0;
        }
        if(i==1 && j==1){
            return 1;
        }
        if(obstacleGrid[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=f(i-1,j,obstacleGrid);
        int left=f(i,j-1,obstacleGrid);
        return dp[i][j]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,obstacleGrid);
    }
}
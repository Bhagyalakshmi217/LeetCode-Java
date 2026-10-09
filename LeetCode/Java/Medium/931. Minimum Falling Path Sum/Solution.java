class Solution {
    int[][] dp;
    int f(int i,int j,int[][] matrix,int[][] dp){
        if(j<0 || j>=matrix[0].length) return (int) 1e8;
        if(i==0) return matrix[0][j];
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=matrix[i][j]+f(i-1,j,matrix,dp);
        int left=matrix[i][j]+f(i-1,j-1,matrix,dp);
        int right=matrix[i][j]+f(i-1,j+1,matrix,dp);
        return dp[i][j]=Math.min(up,Math.min(left,right));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        dp=new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int mini=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            mini=Math.min(mini,f(n-1,j,matrix,dp));
        }
        return mini;
        
    }
}




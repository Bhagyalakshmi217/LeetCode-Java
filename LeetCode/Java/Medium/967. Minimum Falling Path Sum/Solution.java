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
        for(int j=0;j<m;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
               int up=matrix[i][j]+dp[i-1][j];
               int left=matrix[i][j];
               if(j-1>=0){
                left+=dp[i-1][j-1];               
               }
               else{
                left+=(int) 1e8;
               }
               int right=matrix[i][j];
               if(j+1<m){
                right+=dp[i-1][j+1];
               }else{
                right+=(int) 1e8;
               }
               dp[i][j]=Math.min(up,Math.min(left,right));
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            mini=Math.min(mini,dp[n-1][j]);
        }
        return mini;
        
    }
}




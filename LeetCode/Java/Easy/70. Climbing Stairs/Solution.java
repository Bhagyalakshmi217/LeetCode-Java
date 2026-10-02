class Solution {
    public int climbStairs(int n) {
        if(n<=1){
            return n;
        }
        int first=1;
        int sec=1;
        for(int i=2;i<=n;i++){
            int current=first+sec;
            first=sec;
            sec=current;
        }
        return sec;

        // int[] dp=new int[n+1];
        // if(n<=1){
        //     return n;
        // }
        // dp[0]=1;
        // dp[1]=1;
        // for(int i=2;i<=n;i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }
        // return dp[n];
        
    }
}
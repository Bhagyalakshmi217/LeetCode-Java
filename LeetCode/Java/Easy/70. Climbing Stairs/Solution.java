class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int first=1;
        int sec=2;
        for(int i=3;i<=n;i++){
            int current=first+sec;
            first=sec;
            sec=current;
        }
        return sec;
        
    }
}
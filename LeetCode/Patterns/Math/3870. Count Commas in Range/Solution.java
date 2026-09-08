class Solution {
    public int countCommas(int n) {
        int count=0;
        if(n>=1000){
            count+=n-999;
        }
        if(n>=10000){
            count+=n-9999;
        }
        return count;
        
    }
}
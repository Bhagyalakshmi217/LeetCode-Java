class Solution {
    public int countCommas(int n) {
        if(n<1000){
            return 0;
        }
        if(n<10000){
            return n-999;
        }
        return (9999-999)+(n-9999)*2;
        
    }
}
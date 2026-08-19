class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        for(int i=0;i<weights.length;i++){
            left=Math.max(left,weights[i]);
            right=right+weights[i];
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            int noOfDays=1;
            int currLoad=0;
            for(int i=0;i<weights.length;i++){
                if(currLoad+weights[i]<=mid){
                    currLoad+=weights[i];
                }else{
                    noOfDays++;
                    currLoad=weights[i];
                }
            }
            if(noOfDays<=days){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
        
    }
}
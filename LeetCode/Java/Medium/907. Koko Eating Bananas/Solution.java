class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=maximum(piles);       
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            long totalHours=0;
            for(int i=0;i<piles.length;i++){
                totalHours+=(piles[i]+mid-1)/mid;
            }
            if(totalHours<=h){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }

        }
        return ans;
        
    }
    int maximum(int[] piles){
        int maximum=piles[0];
        for(int i=1;i<piles.length;i++){
            if(piles[i]>maximum){
                maximum=piles[i];
            }

        }
        return maximum;
    }
}
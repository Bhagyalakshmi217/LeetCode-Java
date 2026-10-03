class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] temp1=new int[n-1];
        int[] temp2=new int[n-1];
        for(int i=0;i<n;i++){
            
            if(i!=n-1){
                temp1[i]=nums[i];
            }
            if(i!=0){
                temp2[i-1]=nums[i];
            }
        }
        int ans1=houseRobber(temp1);
        int ans2=houseRobber(temp2);
        return Math.max(ans1,ans2);

        
    }
    private int houseRobber(int[] nums){
        int prev = 0;
        int prev2 = 0;

        for (int i = 0; i < nums.length; i++) {

            int take = nums[i]+prev2;
          
            int notTake = prev;

            int curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
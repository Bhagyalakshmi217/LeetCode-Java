class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen=0;
        int left=0;
        int zeros=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeros++;
            }
            while(zeros>0){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            maxLen=Math.max(right-left+1,maxLen);
        }
        return maxLen;

        
    }
}
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int j=0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]!=0){
//             int temp=nums[i];
//             nums[i]=nums[j];
//             nums[j]=temp;
//             j++;
//             }
          
//         }
       
        
//     }
// }



// class Solution{
//     public int moveZeroes(int[] nums){
//         int slow=0;
//         for(int fast=0;fast<nums.length;fast++){
//             if(nums[fast]!=0){
//                 int temp=nums[slow];
//                 nums[slow]=nums[fast];
//                 nums[fast]=temp;
//                 slow++;
//             }
//         }
//         return nums.length;
//     }
// }



class Solution{
    public void moveZeroes(int[] n){
        int slow=0;
        for(int fast=0;fast<n.length;fast++){
            if(n[fast]!=0){
                int temp=n[slow];
                n[slow]=n[fast];
                n[fast]=temp;
            
            slow++;
            }
            
        }
        
    }
}
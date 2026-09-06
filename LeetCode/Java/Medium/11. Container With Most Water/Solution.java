// class Solution {
//     public int maxArea(int[] height) {
//         int left=0;
//         int right=height.length-1;
//         int maxArea=0;
//         while(left<right){
//             int area=Math.min(height[left],height[right])*(right-left);
//             maxArea=Math.max(maxArea,area);
//             if(height[left]<height[right]){
//                 left++;
//             }else{
//                 right--;
//             }
//         }
//         return maxArea;
        
//     }
// }

class Solution{
    public int maxArea(int[] nums){
        int left=0;
        int right=nums.length-1;
        int maxArea=0;
        while(left<right){
            int width=right-left;
            int height=Math.min(nums[left],nums[right]);
            int area=width*height;
            maxArea=Math.max(maxArea,area);
            if(nums[left]<nums[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
        
    }
}
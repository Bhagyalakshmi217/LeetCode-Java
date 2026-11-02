// class Solution {
//     public int trap(int[] height) {
//         int left=0;
//         int right=height.length-1;
//         int leftMax=0;
//         int rightMax=0;
//         int water=0;
//         while(left<right){
//             if(height[left]<height[right]){
//                 if(height[left]>=leftMax){
//                     leftMax=height[left];
//                 }
//                 else{
//                     water+=leftMax-height[left];
//                 }
//                 left++;
//             }
//             else{
//                 if(height[right]>=rightMax){
//                     rightMax=height[right];

//                 }
//                 else{
//                     water+=rightMax-height[right];
//                 }
//                 right--;
//             }
//         }
//         return water;
        
//     }
// }


class Solution {
    public int trap(int[] height) {
        int[] leftMax=new int[height.length];
        int[] rightMax=new int[height.length];
        int totalWater=0;
        // fill leftMAx
        leftMax[0]=height[0];
        for(int i=1;i<height.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }

        // fill rightMax
        rightMax[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        for(int i=0;i<height.length;i++){
            int water=Math.min(leftMax[i],rightMax[i])-height[i];
            totalWater+=water;
        }
        return totalWater;
    }
}
// class Solution {
//     public int trap(int[] height) {

//         int n = height.length;

//         if (n < 3) {
//             return 0;
//         }

//         int[] prefix = new int[n];
//         int[] suffix = new int[n];

//         int total = 0;

//         // Build prefix maximum
//         prefix[0] = height[0];

//         for (int i = 1; i < n; i++) {
//             prefix[i] = Math.max(prefix[i - 1], height[i]);
//         }

//         // Build suffix maximum
//         suffix[n - 1] = height[n - 1];

//         for (int i = n - 2; i >= 0; i--) {
//             suffix[i] = Math.max(suffix[i + 1], height[i]);
//         }

//         // Calculate trapped water
//         for (int i = 0; i < n; i++) {

//             int leftMax = prefix[i];
//             int rightMax = suffix[i];

//             total += Math.min(leftMax, rightMax) - height[i];
//         }

//         return total;
//     }
// }



class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;

        int leftMax=0;
        int rightMax=0;
        int totalWater=0;

        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }
                else{
                    totalWater+=leftMax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }
                else{
                    totalWater+=rightMax-height[right];
                }
            
            right--;
        }
        }
        return totalWater;


    }
}
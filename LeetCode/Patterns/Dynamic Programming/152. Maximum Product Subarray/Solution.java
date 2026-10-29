// class Solution {
//     public int maxProduct(int[] nums) {
//         // tc nd sc are o(n2) nd o(1)
//         int max=nums[0];
//         for(int i=0;i<nums.length;i++){
//             int product=1;
        
//         for(int j=i;j<nums.length;j++){
//             product*=nums[j];
            
//         if(product>max){
//             max=product;
//         }
//         }
//         }
        
//         return max;
        
//     }
// }




class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}
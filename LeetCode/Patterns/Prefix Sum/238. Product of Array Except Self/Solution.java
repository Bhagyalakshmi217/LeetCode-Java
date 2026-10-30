// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n=nums.length;
//         int[] ans=new int[n];

//         // calculate prefix
//         ans[0]=1;

//         for(int i=1;i<n;i++){
//             ans[i]=ans[i-1]*nums[i-1];
//         }
//         // calculate suffix
//         int suffix=1;
//         for(int i=n-1;i>=0;i--){
//             ans[i]=ans[i]*suffix;
//             suffix=suffix*nums[i];
//         }
//         return ans;
        
//     }
// }




class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];

        res[0]=1;
        for(int i=1;i<nums.length;i++){
            res[i]=res[i-1]*nums[i-1];
        }

        int rightProduct=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]=res[i]*rightProduct;
            rightProduct*=nums[i];
        }
        return res;
    }
}
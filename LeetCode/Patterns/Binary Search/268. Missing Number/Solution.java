// class Solution {
//     public int missingNumber(int[] nums) {
//         // tc: o(N) nd sc: o(1)
//         int n=nums.length;
//         int expected_sum=n*(n+1)/2;
//         int actual_sum=0;
//         for(int i=0;i<nums.length;i++){
//             actual_sum+=nums[i];
//         }
//         return expected_sum-actual_sum;
        
//     }
// }



class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for(int i=0;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
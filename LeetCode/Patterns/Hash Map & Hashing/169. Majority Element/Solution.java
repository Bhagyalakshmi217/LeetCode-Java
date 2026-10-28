// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//             if(map.get(nums[i])>nums.length/2){
//                 return nums[i];
//             }
//         }
//         return -1;
        
//     }
// }



// boyre-more voting algo
class Solution {
    public int majorityElement(int[] nums) {
        // tc nd sc:o(N),o(1)
        int count=0;
        int candidate=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidate=nums[i];
            }
            if(nums[i]==candidate){
                count++;
            }else{
                count--;
            }
        }
            return candidate;
        
    }
}

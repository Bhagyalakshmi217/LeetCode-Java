// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         Stack<Integer> stack=new Stack();
//         HashMap<Integer,Integer> map=new HashMap();
//         for(int num:nums2){
//             while(!stack.isEmpty() && num>stack.peek()){
//                 map.put(stack.pop(),num);
//             }
//                 stack.push(num);
//         }while(!stack.isEmpty()){
//             map.put(stack.pop(),-1);


//         }
//         int[] ans=new int[nums1.length];
        
//         for(int i=0;i<nums1.length;i++){
//             ans[i]=map.get(nums1[i]);
//         }
//         return ans;
        
        
//     }
// }

class Solution{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack=new ArrayDeque<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i]>nums2[stack.peek()]){ 
                int value=nums2[stack.pop()];
                map.put(value,nums2[i]);
            }
            stack.push(i);
        }
            while(!stack.isEmpty()){
                map.put(nums2[stack.pop()],-1);
            }
        
            int[] ans=new int[nums1.length];
            for(int i=0;i<nums1.length;i++){
                ans[i]=map.get(nums1[i]);
            }
        
        return ans;

    }
}
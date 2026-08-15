class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack=new ArrayDeque<>();
        int[] result=new int[nums.length];
        Arrays.fill(result,-1);
        for(int i=0;i<2*nums.length;i++){
            int index=i%nums.length;
            while(!stack.isEmpty() && nums[index]>nums[stack.peek()]){
                int prev=stack.pop();
                result[prev]=nums[index];
            }
            if(i<nums.length){
                stack.push(index);
            }

        }
        return result;
        
        
    }
}
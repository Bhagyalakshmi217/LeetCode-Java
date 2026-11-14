class Solution {
    public long subArrayRanges(int[] nums) {
        Deque<Integer> stack=new ArrayDeque<>();
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        long sumMax=0;
        long sumMin=0;
        long ans=0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()?nums.length:stack.peek();
            stack.push(i);
        }
        for(int i=0;i<nums.length;i++){
            long contribution=(long)nums[i]*(i-left[i])*(right[i]-i);
            sumMin+=contribution;
        }
        stack.clear();


        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()?nums.length:stack.peek();
            stack.push(i);
        }
        for(int i=0;i<nums.length;i++){
            long contribution=(long)nums[i]*(i-left[i])*(right[i]-i);
            sumMax+=contribution;
        }

        return sumMax-sumMin;



        }
}



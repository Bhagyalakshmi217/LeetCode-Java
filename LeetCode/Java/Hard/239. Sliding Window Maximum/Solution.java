class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq=new ArrayDeque();
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            // remove expired element
            while(!deq.isEmpty() && deq.peekFirst()<=i-k){                    
                deq.pollFirst();
            }
            // remove smaller elements
            while(!deq.isEmpty() && nums[i]>=nums[deq.peekLast()]){
                deq.pollLast();
            }
            // add current element
            deq.offerLast(i);
            if(i>=k-1){
                // maximum element from front
                ans[idx]=nums[deq.peekFirst()];
                idx++;
            }
        }
        return ans;

    }
}
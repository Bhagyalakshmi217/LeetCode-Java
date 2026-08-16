class Solution {
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> stack=new ArrayDeque<>();
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()? -1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            right[i]=stack.isEmpty()? arr.length:stack.peek();
            stack.push(i);
        }
        long answer=0;
        for(int i=0;i<arr.length;i++){
            long contribution=(long)arr[i]*(i-left[i])*(right[i]-i);
            answer=(answer+contribution)% 1000000007;
        }
        return (int)answer;
        
    }
}
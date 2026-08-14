class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack=new ArrayDeque<>();
        int maxArea=0;
        for(int i=0;i<=heights.length;i++){
            int currHeight;
            int width=0;
            if(i==heights.length){
                currHeight=0;
            }else{
                currHeight=heights[i];
            }
            while(!stack.isEmpty() && currHeight<heights[stack.peek()]){
                int index=stack.pop();
                int height=heights[index];
                if(stack.isEmpty()){
                    width=i;
                }else{
                    width=i-stack.peek()-1;
                }
                maxArea=Math.max(maxArea,height*width);
            }
            stack.push(i);

        }
        return maxArea;

        
    }
}
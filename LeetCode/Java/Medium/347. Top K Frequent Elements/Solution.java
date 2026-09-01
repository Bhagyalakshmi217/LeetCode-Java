class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer>[] bucket=new ArrayList[nums.length+1];
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            map.put(num,map.getOrDefault(num,0)+1);

        }
        for(int i=0;i<bucket.length;i++){
            bucket[i]=new ArrayList<>();
        }
        for(Integer num:map.keySet()){
            int freq=map.get(num);
            bucket[freq].add(num);
        }
        int[] ans=new int[k];
        int index=0;
        for(int i=bucket.length-1;i>=0;i--){
            for(int num:bucket[i]){
                ans[index]=num;
                index++;

                if(index==k){
                    return ans;
                }
            }
            
        }
        return ans;
        
    }
}
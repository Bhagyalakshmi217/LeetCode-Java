class Solution {
    public int longestWPI(int[] hours) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        int maxLen=0;
        map.put(0,-1);
        for(int i=0;i<hours.length;i++){
            if(hours[i]>8){
                count++;
            }else{
                count--;
            }
            if(count>0){
                maxLen=i+1;
            }
            else{
                if(map.containsKey(count-1)){
                    maxLen=Math.max(maxLen,i-map.get(count-1));
            }
            }
            map.putIfAbsent(count,i);
        }
        return maxLen;

        
    }
}
class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int rem=((arr[i]%k)+k)%k;
            
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        if(map.getOrDefault(0,0)%2!=0){
                return false;
            }
       
        for (int rem = 1; rem <= k / 2; rem++) {
            if (rem == k - rem) {
                if (map.getOrDefault(rem, 0) % 2 != 0) {
                    return false;
                }
            } else {
                if (map.getOrDefault(rem, 0) !=
                    map.getOrDefault(k - rem, 0)) {
                    return false;
                }
            }
        }
        return true;
        
    }
}
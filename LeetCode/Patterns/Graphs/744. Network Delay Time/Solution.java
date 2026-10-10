class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // to store that content
        HashMap<Integer,List<int[]>> graph=new HashMap<>();  
        for(int[] edge:times){

        

        // create an empty list(if another node exist)
                graph.putIfAbsent(edge[0],new ArrayList<>());

        // insert neightbour
                graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int d=curr[0];
            int node=curr[1];
            if(d>dist[node]){
                continue;
            }
            if(!graph.containsKey(node)){
                continue;
            }
            for(int[] nei:graph.get(node)){
                int next=nei[0];
                int wt=nei[1];

                if(d+wt<dist[next]){
                    dist[next]=d+wt;
                    pq.offer(new int[]{dist[next],next});
                }
            }

        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans,dist[i]);
        }
        return ans;


        
    }
}
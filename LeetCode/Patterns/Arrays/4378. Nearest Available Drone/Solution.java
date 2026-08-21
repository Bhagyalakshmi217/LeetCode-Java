class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int minDist=Integer.MAX_VALUE;
        int answer=-1;
        for(int i=0;i<drones.length;i++){
            int Dist=Math.abs(drones[i][0]-target[0])+Math.abs(drones[i][1]-target[1]);
            if(Dist<minDist && Dist<=drones[i][2]){
                minDist=Dist;
                answer=i;
            }
            
        }
        return answer;
        
    }
}
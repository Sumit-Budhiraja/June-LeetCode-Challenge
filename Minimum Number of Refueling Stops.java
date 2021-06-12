class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target)
            return 0;
        if(stations==null || stations.length==0)
            return -1;
        int currFuel= startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int stops=0;
        int i=0;
        while(currFuel < target) {
            while(i<stations.length && stations[i][0]<=currFuel) {
                pq.add(stations[i][1]);
                i++;
            }
            if(pq.isEmpty())
                return -1;
            currFuel+=pq.remove();
            stops++;
        }
        return stops;
    }
}
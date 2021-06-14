class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] buckets = new int[1001];
        int units = 0;
        
        for (int i = 0; i < boxTypes.length; i++) {
            if (buckets[boxTypes[i][1]] == 0) {
                buckets[boxTypes[i][1]] = boxTypes[i][0];
            } else {
                buckets[boxTypes[i][1]] += boxTypes[i][0];
            }
        }
        
        for (int i = 1000; truckSize > 0 && i >= 0; --i) {
            if (buckets[i] == 0) continue;

            units += Math.min(truckSize, buckets[i])*i;
            truckSize -= buckets[i]; 
        }
        
        return units;
    }
};
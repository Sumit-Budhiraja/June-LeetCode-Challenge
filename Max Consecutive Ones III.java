class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int maxLength = 0;
        int zeroesCount = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            zeroesCount += nums[windowEnd] == 0 ? 1 : 0;
            
            while(zeroesCount > k) {
                if (nums[windowStart++] == 0)
                    --zeroesCount;
            }
            
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        
        return maxLength;
    }
}
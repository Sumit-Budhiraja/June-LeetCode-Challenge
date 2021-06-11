class Solution {
    
    int[][] dp = null;
    
    private int solve(int[] stones, int start, int end, int sum){
        if(start>=end){
            return 0;
        }
        if(dp[start][end] !=-1){
            return dp[start][end];
        }
        
        int scoreOnRemovingFirst = sum - stones[start];
        int scoreOnRemovingLast = sum - stones[end];
        
        dp[start][end] = Math.max(scoreOnRemovingFirst - solve(stones, start+1, end, scoreOnRemovingFirst),
                                 scoreOnRemovingLast - solve(stones, start, end-1, scoreOnRemovingLast));
                                  
        return dp[start][end];
                                  
    }
    
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int sum = 0;
        for(int num: stones){
            sum += num;
        }
        return solve(stones, 0, n-1, sum);
        
    }
}
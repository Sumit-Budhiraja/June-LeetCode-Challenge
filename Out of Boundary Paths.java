class Solution {
    
    public int solve(int m, int n, int maxMove, int row, int col, int[][][] hash) {
        
        if(row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
        
        if(maxMove <= 0) return 0;
        int sum = 0;
        
        if(hash[maxMove][row][col] != -1) return hash[maxMove][row][col];
        sum = (sum + solve(m, n, maxMove - 1, row + 1, col, hash))%((int)(1e9) + 7);
        sum = (sum + solve(m, n, maxMove - 1, row - 1, col, hash))%((int)(1e9) + 7);
        sum = (sum + solve(m, n, maxMove - 1, row, col + 1, hash))%((int)(1e9) + 7);
        sum = (sum + solve(m, n, maxMove - 1, row, col - 1, hash))%((int)(1e9) + 7);
        
        
        return hash[maxMove][row][col] = sum;
        
    }
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] hash = new int[maxMove + 1][m + 1][n + 1];
        
        for(int i = 0; i < maxMove + 1; i++) {
            for(int j = 0; j <= m; j++) {
                for(int k = 0; k <= n; k++) {
                    hash[i][j][k] = -1;
                }
            }
        }
        
        return solve(m, n, maxMove, startRow, startColumn, hash);
    }
}
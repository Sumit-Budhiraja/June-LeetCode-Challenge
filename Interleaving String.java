class Solution {
    
    public boolean dfs (String s1, String s2, String s3, int i, int j, int k, boolean[][] dp) {
        
        if (k == s3.length ()) {
            return true;
        }
        else if (dp[i][j]) {
            return false;
        }
        
        boolean valid = i < s1.length () && s1.charAt (i) == s3.charAt (k) && dfs (s1, s2, s3, i + 1, j, k + 1, dp) || j < s2.length () && s2.charAt (j) == s3.charAt (k) && dfs (s1, s2, s3, i, j + 1, k + 1, dp);
        
        if (!valid) {
            dp[i][j] = true;
        }
        
        return valid;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        return s1.length () + s2.length () == s3.length () ? dfs (s1, s2, s3, 0, 0, 0, new boolean[s1.length () + 1][s2.length () + 1]) : false;
    }
}
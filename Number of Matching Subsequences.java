class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for(String word:words){
            if(isSubsequence(S,word))
                count++;
        }       
        return count;
    }
    
    public boolean isSubsequence(String str,String t){
        int i = 0, j = 0, l1 = str.length(), l2 = t.length();
        if(l2 > l1){
            return false;
        }
        while(i < l1 && j < l2){
            if(str.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j == l2;
    }
}
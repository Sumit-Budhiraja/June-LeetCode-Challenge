class Solution {
      private static int[] P10= {1, 10, 100, 1000};
    private static int[] FWD_BWD= {1, 9};
    
    public int openLock(String[] deadends, String target) {
        boolean[] seen= new boolean[10000];
        for(int i=0; i<deadends.length; i++) 
            seen[Integer.parseInt(deadends[i])]= true;
        if(seen[0]) return -1;
        int tIdx= Integer.parseInt(target);
        if(tIdx==0) return 0;
        Queue<Integer> queue= new ArrayDeque<>();
        seen[0]= true;
        queue.add(0);
        for(int level= 0; !queue.isEmpty(); level++){
            int k= queue.size();
            // for each code attempt 8 transitions, check for 1. target 2. visited/dead
            while(k-->0)
                for(int idx= queue.poll(), j=0; j<4; j++)
                    for(int fwdBwd:FWD_BWD){
                        int digit= idx/P10[j]%10;
                        int next= idx+((digit+fwdBwd)%10-digit)*P10[j];
                        if(next==tIdx) return level+1;
                        if(seen[next]) continue;
                        seen[next]= true;
                        queue.add(next);
                    }
        }
        return -1;
    }
}
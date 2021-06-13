class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> al=new ArrayList<List<Integer>>();
        for(int i=0;i<words.length-1;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                String k=words[i]+words[j];
                String t=words[j]+words[i];
                if(ispalin(k))
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(i);
                    l.add(j);
                    al.add(l);
                }
                if(ispalin(t))
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(j);
                    l.add(i);
                    al.add(l);
                }
            }
        }
        return al;
    }
    boolean ispalin(String s)
    {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
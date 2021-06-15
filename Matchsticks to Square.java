class Solution {
    public boolean makesquare(int[] nums) {
        if(nums.length<4) return false;
        
        int sum=0;
        for(int num : nums)
            sum+=num;
        if(sum%4!=0) return false;
        return sol(nums,0,new int[4],sum/4);
    }
    
    public boolean sol(int[] nums,int idx,int[] dims,int len){
        if(idx==nums.length) return true;
        
        for(int i=0;i<4;i++){
            if(dims[i]+nums[idx]<=len){
                
                dims[i]+=nums[idx];
                if(sol(nums,idx+1,dims,len)) return true;
                dims[i]-=nums[idx];
                
            }
            
            
        }
        return false;
        
    }
    
}
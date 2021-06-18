class NumArray {
    int[] nums; // underlying array
    int[] bit;  // BIT holding prefix sums
    int n;
    
    public NumArray(int[] nums) {
        this.nums= nums;
        this.n= nums.length+1;
        this.bit= new int[this.n];
        for(int index=0; index<nums.length; index++){
            add(index+1, nums[index]);
        }
    }
    
    public void update(int index, int val) {
        int diff= val-nums[index];
        nums[index]= val;
        add(index+1, diff);       
    }
    
    private void add(int i, int diff){
        for(; i<n; i+= Integer.lowestOneBit(i))
            bit[i]+= diff;      
    }
    
    public int sumRange(int left, int right) {
        return rsq(right+1)-rsq(left); 
    }
    
    private int rsq(int i){
        int ps= 0;
        for(; i!=0; i-= Integer.lowestOneBit(i))
            ps+= bit[i];
        return ps;
    }    
}
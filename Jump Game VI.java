class Solution {
    public int maxResult(int[] nums, int k) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, dp[0]});
        
        for(int i = 1; i < nums.length; i++) {
			//remove all elements that more than k dist away
			while(queue.peekFirst()[0] < i - k) {
                queue.pollFirst();
            }
	        //first element in the queue is always the max element	
            dp[i] = queue.peekFirst()[1] + nums[i];
	        
			//remove all elements from right that are smaller than cur element, 
			//since they can never be used as max
            while(!queue.isEmpty() && queue.peekLast()[1] < dp[i]){
                queue.pollLast();
            }
            queue.addLast(new int[]{i, dp[i]});
        }
        
        return dp[nums.length - 1];
    }
}
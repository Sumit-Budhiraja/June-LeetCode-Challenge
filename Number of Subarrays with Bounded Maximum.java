class Solution {
  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
	int n = nums.length;
	int cnt = 0;

	for(int i = 0, j = 0, k = 0; j < n; j++) {
		if(nums[j] < left) {
			k++;
		} else {
			i = nums[j] > right ? j + 1 : i;
			k = 0;
		}
		cnt += (j - i + 1);
		cnt -= k;
	} 

	return cnt;
}
}
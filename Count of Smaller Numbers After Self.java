class Solution {
   public static List<Integer> countSmaller(int[] nums) {
        List<Integer> counts = new ArrayList<Integer>(nums.length); // Create a list with the same size as the initial array

        if (nums.length == 0  || nums.length == Integer.MAX_VALUE){ // Prevent errors
            return counts;
        }

        for (int i = 0; i < nums.length - 1; i++){ // Search all the elements until the n-1 element
            int smaller = 0; // Keep the number of the smallest values to the right of the current one
            for (int j = i+1; j <= nums.length - 1; j++) // Check only the right elements of the current one
                if (nums[j] < nums[i]) smaller++;
            counts.add(i, smaller);
        }
        counts.add(nums.length-1, 0); // The last element does not have any other to its right
        return counts; // Return the list
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Expand the window
            sum += nums[right];

            // Shrink the window while it is valid
            while (sum >= target) {

                // Current window satisfies the condition
                minLen = Math.min(
                    minLen,
                    right - left + 1
                );

                // Remove the leftmost element
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
class Solution {
    Integer[] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new Integer[nums.length+1];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, solve(nums, i));
        }

        return max;
    }

    public int solve(int[] nums, int i) {
        if (memo[i] != null) {
            return memo[i];
        }

        int max = 1;

        for (int j = i+1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                max = Math.max(solve(nums, j) + 1, max);
            }
        }

        memo[i] = max;

        return max;
    }
}

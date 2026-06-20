class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length+1];

        return Math.max(recursive(0, nums, memo), recursive(1, nums, memo));
    }

    public int recursive(int i, int[] nums, int[] memo) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] > 0) {
            return memo[i];
        }

        memo[i] = nums[i] + Math.max(recursive(i+2, nums, memo), recursive(i+3, nums, memo));
        
        return memo[i];
    }
}

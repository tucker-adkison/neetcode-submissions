class Solution {
    Integer[] memo;

    public int combinationSum4(int[] nums, int target) {
        memo = new Integer[target+1];

        return solve(nums, target, 0);
    }

    public int solve(int[] nums, int target, int sum) {
        if (target == sum) {
            return 1;
        }

        if (sum > target) {
            return 0;
        }

        if (memo[sum] != null) {
            return memo[sum];
        }

        int result = 0;

        for (int j = 0; j < nums.length; j++) {
            result += solve(nums, target, sum + nums[j]);
        }

        memo[sum] = result;

        return result;
    }
}
class Solution {
    Integer[][] memo;

    public int combinationSum4(int[] nums, int target) {
        memo = new Integer[nums.length+1][target+1];

        return solve(nums, target, 0, 0);
    }

    public int solve(int[] nums, int target, int sum, int i) {
        if (target == sum) {
            return 1;
        }

        if (sum > target) {
            return 0;
        }

        if (memo[i][sum] != null) {
            return memo[i][sum];
        }

        int result = 0;

        for (int j = 0; j < nums.length; j++) {
            result += solve(nums, target, sum + nums[j], j);
        }

        memo[i][sum] = result;

        return result;
    }
}
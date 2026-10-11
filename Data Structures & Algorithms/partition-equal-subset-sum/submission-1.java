class Solution {
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        memo = new Boolean[nums.length][sum/2 + 1];

        for (int i = 0; i < nums.length; i++) {
            if (solve(nums, 0, sum / 2, i)) {
                return true;
            }
        }

        return false;
    }   

    public boolean solve(int[] nums, int curr, int mid, int i) {
        if (i >= nums.length || curr > mid) {
            return false;
        }

        if (curr == mid) {
            memo[i][mid] = true;
            return true;
        }

        if (memo[i][curr] != null) {
            return memo[i][curr];
        }

        for (int j = i; j < nums.length; j++) {
            if (solve(nums, curr + nums[j], mid, j+1)) {
                return true;
            }
        }

        memo[i][curr] = false;

        return false;
    }
}

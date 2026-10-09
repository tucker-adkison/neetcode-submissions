class Solution {
    Integer[] first;
    Integer[] second;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } 

        first = new Integer[nums.length + 1];
        second = new Integer[nums.length + 1];

        return Math.max(solve(nums, 0, true), solve(nums, 1, false));
    }

    public int solve(int[] nums, int i, boolean isFirst) {
        if (i >= nums.length - 1 && isFirst) {
            return 0;
        } else if (i >= nums.length) {
            return 0;
        }

        if (isFirst && first[i] != null) {
            return first[i];
        } else if (second[i] != null) {
            return second[i];
        }

        int result = Math.max(nums[i] + solve(nums, i+2, isFirst), solve(nums, i+1, isFirst));

        if (isFirst) {
            first[i] = result;
        } else {
            second[i] = result;
        }

        return result;
    }
}

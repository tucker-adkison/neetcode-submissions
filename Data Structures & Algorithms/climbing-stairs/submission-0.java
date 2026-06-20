class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];

        return recursive(n, memo);
    }

    public int recursive(int n, int[] memo) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = recursive(n-1, memo) + recursive(n-2, memo);

        return memo[n];
    }
}

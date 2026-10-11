class Solution {
    Integer[] memo;

    public int numSquares(int n) {
        int upperBound = (int) Math.floor(Math.sqrt(n));

        memo = new Integer[n];

        return solve(n, upperBound, 0, 0);
    }


    public int solve(int n, int upperBound, int sum, int depth) {
        if (sum == n) {
            return depth;
        }
        if (sum > n) {
            return Integer.MAX_VALUE;
        }

        if (memo[sum] != null) {
            return memo[sum];
        }

        int min = n;

        for (int i = upperBound; i >= 1; i--) {
            min = Math.min(min, solve(n, upperBound, sum + i*i, depth+1));
        }

        memo[sum] = min;

        return min;
    }
}
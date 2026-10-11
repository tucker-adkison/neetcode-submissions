class Solution {
    Integer[] memo;
    
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        memo = new Integer[n+1];

        return solve(n, 0);
    }

    public int solve(int n, int s) {
        if (s == n) {
            return 1;
        } else if (s >= n) {
            return 0;
        }

        if (memo[s] != null) {
            return memo[s];
        }

        int max = 0;

        for (int i = 2; i <= n; i++) {
            max = Math.max(max, solve(n, s + i) * i);
        }

        memo[s] = max;

        return max;
    }
}
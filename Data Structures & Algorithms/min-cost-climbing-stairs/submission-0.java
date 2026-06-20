class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length+1];
        
        return Math.min(recursive(0, cost, memo), recursive(1, cost, memo));
    }

    public int recursive(int i, int[] cost, int[] memo) {
        if (i >= cost.length) {
            return 0;
        }

        if (memo[i] > 0) {
            return memo[i];
        }

        memo[i] = Math.min(recursive(i+1, cost, memo), recursive(i+2, cost, memo)) + cost[i];
        
        return memo[i];
    }   
}
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        
        dp[dp.length - 1] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            char digit = s.charAt(i);

            if (digit != '0') {
                if (i+1 < s.length()) {
                    int digits = Integer.valueOf(s.substring(i, i+2));

                    if (digits <= 26) {
                        dp[i] += dp[i+2];
                    }
                }

                dp[i] += dp[i+1];
            }
        } 

        return dp[0];
    }
}

class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];

        return recursive(s, 0, memo);
    }

    public int recursive(String s, int index, int[] memo) {
        if (memo[index] > 0) {
            return memo[index];
        }

        int count = 0;
        if (index == s.length()) {
            return 1;
        } else if (index > s.length()) {
            return 0;
        }

        int digit = s.charAt(index) - '0';

        if (index+1 < s.length() && (digit == 1 || digit == 2)) {
            int digits = Integer.valueOf(s.substring(index, index+2));
            
            if (digits <= 26) {
                count += recursive(s, index+2, memo);
            }
        }

        if (digit >= 1 && digit <= 9) {
            count += recursive(s, index+1, memo);
        }

        memo[index] = count;

        return memo[index];
    }
}

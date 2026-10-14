class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char c1 = Character.toLowerCase(s.charAt(i));
            char c2 = Character.toLowerCase(s.charAt(j));

            if (!Character.isLetterOrDigit(c1)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(c2)) {
                j--;
                continue;
            }

            if (c1 == c2) {
                i++;
                j--;
            } else {
                return false;
            }

            if (i == j) {
                return true;
            }
        }

        return true;
    }
}

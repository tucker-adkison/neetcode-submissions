class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = "";

        if (strs.length == 0) {
          return pre;
        }

        int index = 0;

        for(;;) {
            if (index < strs[0].length()) {
                char first = strs[0].charAt(index);
                for (String str : strs) {
                    if (index < str.length() && str.charAt(index) == first) {
                        continue;
                    } else {
                        return pre;
                    }
                }

                pre += first;
                index++;
            } else {
                return pre;
            }
        }
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> memo = new HashMap<>();
        boolean isFound = recursive(s, wordDict, 0, "", memo);
        System.out.println(memo);

        return isFound;
    }

    public boolean recursive(String s, List<String> wordDict, int i, String currWord, HashMap<String, Boolean> memo) {
        if (memo.containsKey(currWord)) {
            return memo.get(currWord);
        }
        
        if (i == s.length()) {
            for (String word : wordDict) {
                if (word.equals(currWord)) {
                    return true;
                }
            }

            return false;
        }

        boolean isFound = false;
        
        for (String word : wordDict) {
            if (word.equals(currWord)) {
                isFound = true;
                break;
            }
        }

        if (isFound) {
            // word break
            isFound = recursive(s, wordDict, i+1, s.charAt(i) + "", memo);
            memo.put(currWord, isFound);
        }

        if (!isFound) {
            // no word break
            isFound = recursive(s, wordDict, i+1, currWord + s.charAt(i), memo);
            memo.put(currWord, isFound);
        }

        return isFound;
    }
}

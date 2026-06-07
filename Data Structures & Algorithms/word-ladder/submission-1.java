class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> adj = new HashMap<>();
        HashMap<String, Integer> dist = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        queue.add(beginWord);
        dist.put(beginWord, 1);

        int count = 0;

        while (!queue.isEmpty()) {
            count++;
            String word = queue.poll();

            for (String neighbor : getNeighbors(wordList, word)) {
                if (!dist.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    dist.put(neighbor, dist.get(word) + 1);
                }
            }
        }

        return dist.get(endWord) == null || dist.get(endWord) == Integer.MAX_VALUE ? 0 : dist.get(endWord);
    }

    public List<String> getNeighbors(List<String> wordList, String w1) {
        ArrayList<String> neighbors = new ArrayList<>();
        for (String w2 : wordList) {
            int diff = 0;
            for (int i = 0; i < w1.length(); i++) {
                if (w1.charAt(i) != w2.charAt(i)) {
                    diff++;
                }
            }

            if (diff == 1) {
                neighbors.add(w2);
            }
        }

        return neighbors;
    }
}
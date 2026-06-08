class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }

        PriorityQueue<Count> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int key : counts.keySet()) {
            pq.add(new Count(key, counts.get(key)));
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().element;
        }

        return result;
    }

    public record Count(int element, int count) implements Comparable<Count> {
        @Override
        public int compareTo(Count other) {
            return Integer.compare(this.count, other.count);
        }
    }
}

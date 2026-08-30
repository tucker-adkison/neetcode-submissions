class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> counts = new HashMap<>();
       int n = nums.length;

        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }

        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int key : counts.keySet()) {
            buckets.get(counts.get(key)).add(key);
        }

        int[] result = new int[k];

        int count = 0;
        for (int i = buckets.size()-1; i > 0; i--) {
            if (count == k) {
                break;
            }
            
            List<Integer> bucket = buckets.get(i);
            if (!bucket.isEmpty()) {
                int j = 0;
                for (int elem : bucket) {
                    if (k == count) {
                        return result;
                    }

                    result[count] = elem;
                    count++;
                }
            }
        }

        return result;
    }
}

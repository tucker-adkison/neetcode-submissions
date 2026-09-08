class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,  Integer> elements = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for (int num : nums) {
            if (elements.containsKey(num)) {
                elements.put(num, elements.get(num) + 1);
            } else {
                elements.put(num, 1);
            }
        }

        for (int num : elements.keySet()) {
            int value = elements.get(num);

            if (value > Math.floor(nums.length/3)) {
                results.add(num);
            }
        }

        return results;
    }
}
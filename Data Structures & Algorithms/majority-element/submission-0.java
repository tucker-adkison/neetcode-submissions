class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int cap = (int) Math.floor(nums.length / 2);

        for (int num : nums) {
            if (counts.containsKey(num)) {
                int value = counts.get(num) + 1;

                if (value > cap) {
                    return num;
                }
                
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }

        return nums[0];
    }
}
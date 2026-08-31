class Solution {
    HashSet<Integer> set = new HashSet<>();

    int maxSize = 0;

    public int longestConsecutive(int[] nums) {
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int temp = num;

            if(!set.contains(temp-1)){
                int length = 0;

                while (set.contains(temp)) {
                    length++;
                    temp++;
                }

                maxSize = Math.max(length, maxSize);
            }

        }

        return maxSize;
    }
}

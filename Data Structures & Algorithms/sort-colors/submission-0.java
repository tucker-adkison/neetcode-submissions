class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];

        for (int num : nums) {
            colors[num]++;
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            int color = colors[i];
            for (int j = 0; j < color; j++) {
                nums[count] = i;
                count++;
            }
        }
    }
}
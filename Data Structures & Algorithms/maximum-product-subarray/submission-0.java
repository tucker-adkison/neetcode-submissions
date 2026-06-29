class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];

        System.out.println(min + " " + max);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = max * num;
            int tempMin = min * num;

            min = Math.min(num, tempMin);
            min = Math.min(min, tempMax);

            max = Math.max(num, tempMin);
            max = Math.max(max, tempMax);

            result = Math.max(result, max);
        }

        return result;
    }
}

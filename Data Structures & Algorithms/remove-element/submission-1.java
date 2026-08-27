class Solution {
    public int removeElement(int[] nums, int val) {
        int found = 0;
        int i = 0;

        while (i < nums.length - found) {
            if (nums[i] == val) {
                int j = i;
                while (j+1 < nums.length - found) {
                    swap(nums, j, j+1);
                    j++;
                }
                
                found++;
            }

            if (nums[i] != val) {
                i++;
            }
        }
        
        return nums.length - found;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
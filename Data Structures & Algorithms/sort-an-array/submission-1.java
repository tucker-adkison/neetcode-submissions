class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(0, nums.length-1, nums);
    }

    public int[] mergeSort(int start, int end, int[] nums) {
        if (start < end) {
            int mid = (int) Math.floor((start+end) / 2);
            
            int[] left = mergeSort(start, mid, nums);
            int[] right = mergeSort(mid+1, end, nums);

            int i = 0;
            int j = 0;
            int k = 0;

            int mergedLength = left.length + right.length;
            int[] merged = new int[mergedLength];

            while (k < merged.length) {
                if (i == left.length) {
                    merged[k] = right[j];
                    j++;
                } else if (j == right.length) {
                    merged[k] = left[i];
                    i++;
                } else if (left[i] <= right[j]) {
                    merged[k] = left[i];

                    i++;
                } else {
                    merged[k] = right[j];

                    j++;
                }
                k++;
            }

            return merged;
        } else {
            return new int[] {nums[start]};
        }
    }
}
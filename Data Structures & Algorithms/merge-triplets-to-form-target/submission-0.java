class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] result = new int[target.length];

        for (int[] triplet : triplets) {
            boolean stop = false;
            for (int i = 0; i < triplet.length; i++) {
                if (Math.max(triplet[i], result[i]) > target[i]) {
                    stop = true;
                    break;
                }
            }

            if (stop) {
                continue;
            } else {
                for (int i = 0; i < triplet.length; i++) {
                    result[i] = Math.max(triplet[i], result[i]);
                }
            }
        }

        return Arrays.equals(result, target);
    }
}

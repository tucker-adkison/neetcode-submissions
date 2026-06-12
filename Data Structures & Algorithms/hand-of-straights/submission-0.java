class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int h : hand) {
            if (counts.containsKey(h)) {
                counts.put(h, counts.get(h) + 1);
            } else {
                counts.put(h, 1);
            }
        }

        while (!counts.isEmpty()) {
            int largest = -1;
            for (int key : counts.keySet()) {
                if (key >= largest) {
                    largest = key;
                }
            }

            if (counts.get(largest) - 1 == 0) {
                counts.remove((Integer) largest);
            } else {
                counts.put(largest, counts.get(largest) - 1);
            }

            if (!recurse(counts, groupSize, largest, 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean recurse(HashMap<Integer, Integer> counts, int groupSize, int curr, int currGroupSize) {
        if (groupSize == currGroupSize) {
            return true;
        }
        
        if (counts.containsKey(curr - 1) && counts.get(curr - 1) > 0) {
            if (counts.get(curr-1) - 1 == 0) {
                counts.remove((Integer) (curr - 1));
            } else {
                counts.put(curr-1, counts.get(curr-1) - 1);
            }

            return recurse(counts, groupSize, curr-1, currGroupSize + 1);
        } 
        
        return false;
    }
}

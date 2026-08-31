class Solution {
    HashMap<Integer, Integer> parents = new HashMap<>();
    HashMap<Integer, Integer> size = new HashMap<>();

    int maxSize = 1;

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        for (int num : nums) {
            parents.put(num, num);
            size.put(num, 1);
        }

        for (int num : nums) {
            if (parents.containsKey(num-1)) {
                merge(num-1, num);
            }
        }

        return maxSize;
    }

    // def find(self, i):
    //     if self.parent[i] == i:
    //         return i
    //     self.parent[i] = self.find(self.parent[i])
    //     return self.parent[i]

    public int find(int x) {
        if (parents.get(x) == x) {
            return x;
        }

        parents.put(x, find(parents.get(x)));

        return parents.get(x);
    }

    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        int sizeX = size.get(rootX);
        int sizeY = size.get(rootY);

        if (sizeX < sizeY) {
            parents.put(rootX, rootY);
            size.put(rootY, sizeY + sizeX);
        } else {
            parents.put(rootY, rootX);
            size.put(rootX, sizeY + sizeX);
        }

        maxSize = Math.max(maxSize, sizeY + sizeX);
    }
}

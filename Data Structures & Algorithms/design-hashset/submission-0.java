class MyHashSet {

    int[] arr;
    int tableSize = 10001;

    public MyHashSet() {
        arr = new int[tableSize];

        for (int i = 0; i < tableSize; i++) {
            arr[i] = -1;
        }
    }
    
    public void add(int key) {
        int hash = (int) (Math.abs(hash(String.valueOf(key))) % (tableSize-1));

        arr[hash] = key;
    }
    
    public void remove(int key) {
        int hash = (int) (Math.abs(hash(String.valueOf(key))) % (tableSize-1));

        arr[hash] = -1;
    }
    
    public boolean contains(int key) {
        int hash = (int) (Math.abs(hash(String.valueOf(key))) % (tableSize-1));

        return arr[hash] > -1;
    }

    public long hash(String str) {
        long hash = 5381; // Initialization of the hash
        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) + hash) + str.charAt(i); // hash * 33 + c
        }
        return hash; // Return the final hash value
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
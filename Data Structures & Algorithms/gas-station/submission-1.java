class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (greedy(i, gas[i], gas, cost, i)) {
                return i;
            }
        }

        return -1;
    }

    public boolean greedy(int i, int amount, int[] gas, int[] cost, int firstStation) {
        int newIndex = i+1 == gas.length ?  0 : i+1;
        int newAmount = amount - cost[i];

        // System.out.println(firstStation + " " + i + " " + amount + " " + newAmount);

        if (newAmount >= 0 && newIndex == firstStation) {
            return true;
        }

        if (newAmount <= 0) {
            return false;
        } 
        
        return greedy(newIndex, newAmount + gas[newIndex], gas, cost, firstStation);
    }
}

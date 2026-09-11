class Solution {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        long power = Math.abs((long) n);
        double result = 0;

        if (power % 2 == 0) {
            double base = myPow(x, (int) (power/2));
            result = base * base;
        } else {
            result = x * myPow(x, (int) (power-1));
        }

        return n < 0 ? 1 / result : result;
    }
}
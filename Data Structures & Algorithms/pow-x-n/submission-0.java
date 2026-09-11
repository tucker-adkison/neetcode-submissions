class Solution {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }

        if (n < 0) {
            if (n % 2 == 0) {
                double base = myPow(x, Math.abs(n/2));
                return 1 / (base * base);
            } else {
                return 1 / (x * myPow(x, Math.abs(n+1)));
            }
        }

        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            double base = myPow(x, n/2);
            return base * base;
        } else {
            return x * myPow(x, n-1);
        }
    }
}
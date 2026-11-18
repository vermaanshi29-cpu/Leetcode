
class Solution {
    public double myPow(double x, int n) {

        long N = Math.abs((long) n);

        double ans = 1.0;

        while (N > 0) {

            if (N % 2 == 1) {
                ans = ans * x;
            }

            x = x * x;

            N = N / 2;
        }

        // Handle negative exponent at the end
        if (n < 0) {
            return 1.0 / ans;
        }

        return ans;
    }
}


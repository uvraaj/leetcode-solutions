class Solution {
    public double myPow(double x, int n) {

        //base case
        if (n == 0) { return 1; }

        //edge case 1: for negative values of n
        if (n < 0) {
            x = 1 / x;
            //edge case 2: for Integer.MIN_VALUE
            if (n == Integer.MIN_VALUE) { return x * myPow(x , Integer.MAX_VALUE); }
            n = -n;
        }

        //EDGE CASE 3: for handling extremely large values
        if (n % 2 == 0) {
            double half = myPow(x, n/2);
            return half * half;
        }

        else return x * myPow(x, n - 1);
        
    }
}
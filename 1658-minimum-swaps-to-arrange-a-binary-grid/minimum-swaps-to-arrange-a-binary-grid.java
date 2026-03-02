class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] conseq0 = new int[n]; // Count trailing zeros for all rows
        for (int i = 0; i < n; ++i)
        {
            int counter = 0;
            for (int j = n - 1; j >= 0; --j)
            {
                if (grid[i][j] != 0)
                    break;
                counter++;
            }
            conseq0[i] = counter;
        }
        int numNeeded = n - 1;
        int ans = 0;
        while (numNeeded > 0)
        {
            boolean flag = false;
            for (int i = n - numNeeded - 1; i < n; ++i)
            {
                if (conseq0[i] >= numNeeded)
                {
                    //Perform the swaps
                    int temp = conseq0[i];
                    for (int k = i; k > n - numNeeded - 1; --k)
                        conseq0[k] = conseq0[k - 1];
                    conseq0[n - numNeeded - 1] = temp;
                    flag = true;
                    //Calculate the number of swaps
                    ans += i - (n - numNeeded - 1);
                    break;
                }
            }
            if (!flag)
                return -1;
            numNeeded--;
        }
        return ans;
    }
}
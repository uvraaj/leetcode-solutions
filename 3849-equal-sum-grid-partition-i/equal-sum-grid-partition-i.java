class Solution {
    static public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long totalRowSum = 0L, totalColSum = 0L;
        long[] prefixRowWise = new long[n];
        long[] prefixColWise = new long[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = grid[i][j];
                long vl = v;
                prefixRowWise[i] += vl;
                prefixColWise[j] += vl;
            }
        }

        for (long r : prefixRowWise) totalRowSum += r;
        totalColSum = totalRowSum;

        long currentRowUpperSum = 0L;
        for (int i = 0; i < n - 1; i++) {
            currentRowUpperSum += prefixRowWise[i];
            long lowerSegmentSum = totalRowSum - currentRowUpperSum;
            if (currentRowUpperSum == lowerSegmentSum) return true;
        }

        long currentColLeftSum = 0L;
        for (int j = 0; j < m - 1; j++) {
            currentColLeftSum += prefixColWise[j];
            long rightSegmentSum = totalColSum - currentColLeftSum;
            if (currentColLeftSum == rightSegmentSum) return true;
        }
        return false;
    }
}
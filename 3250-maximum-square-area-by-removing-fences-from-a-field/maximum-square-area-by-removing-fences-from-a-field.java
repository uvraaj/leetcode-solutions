class Solution {
    static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        // add boundaries
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[h.length - 1] = m;
        v[0] = 1;
        v[v.length - 1] = n;

        for (int i = 0; i < hFences.length; i++) h[i + 1] = hFences[i];
        for (int i = 0; i < vFences.length; i++) v[i + 1] = vFences[i];

        Arrays.sort(h);
        Arrays.sort(v);

        // all possible vertical distances
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                set.add(h[j] - h[i]);
            }
        }

        long best = -1;

        // match horizontal distances
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int d = v[j] - v[i];
                if (set.contains(d)) {
                    best = Math.max(best, d);
                }
            }
        }

        if (best == -1) return -1;

        return (int) ((best * best) % MOD);
    }
}
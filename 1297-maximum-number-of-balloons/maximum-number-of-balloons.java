class Solution {
    public int maxNumberOfBalloons(String s) {
        int[] f = new int[5];
        for (int i = 0; i < s.length(); i++) {
            int idx = "balon".indexOf(s.charAt(i));
            if (idx != -1) f[idx]++;
        }

        f[2] >>= 1;
        f[3] >>= 1;

        return Arrays.stream(f).min().getAsInt();
    }
}
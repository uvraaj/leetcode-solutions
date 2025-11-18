class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int[] bindMap = new int[n];

        for(int i = 0; i < n; i++) {
            if(bits[i] == 1 && bindMap[i] != 1) {
                bindMap[i] = 1;
                if(i+1 < n) bindMap[i+1] = 1;
            }
        }

        if(bits[n-1] == 1) return false;
        else return bindMap[n-1] == 0;
    }
}
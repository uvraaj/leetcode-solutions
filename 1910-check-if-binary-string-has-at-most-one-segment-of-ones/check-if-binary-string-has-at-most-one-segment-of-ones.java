class Solution {
    public boolean checkOnesSegment(String s) {
        boolean f=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') f=true;
            else if(s.charAt(i)=='1' && f) return false;
        }
        return true;
    }
}
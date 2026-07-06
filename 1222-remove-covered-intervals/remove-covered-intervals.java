class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            else{
                return Integer.compare(a[0],b[0]);
            }
        });
        
        int l = intervals[0][0];
        int r = intervals[0][1];
        int removed = 0;
        
        for(int i=1; i<intervals.length; i++){
            if(l <= intervals[i][0] && intervals[i][1] <= r){
                removed++; // interval covered
            }
            else{
                l = intervals[i][0];
                r = intervals[i][1];
            }
        }
        return intervals.length - removed;
    }
}
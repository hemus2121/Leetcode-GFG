class Solution {
    public int[][] merge(int[][] intervals) {
        
        List <int []> resList = new ArrayList();
        //boundary case
        if(intervals==null || intervals.length== 0){
            return resList.toArray(new int [0][]);
        }
        
        //sort based on 1st parameter of intervals
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        //Iterate for intervals
        for (int [] i : intervals){
            if ( i[0] <= end){
                end  = Math.max(end, i[1]);
            }else {
                resList.add (new int []{ start, end});
                start = i[0];
                end = i[1];
            }
        }
        resList.add(new int []{start,end});
        return resList.toArray(new int [0][1]);
        
    }
}
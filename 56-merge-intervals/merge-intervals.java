class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            int compareFirst = Integer.compare(a[0], b[0]);
            if(compareFirst == 0){
                compareFirst = Integer.compare(a[1], b[1]);
                return compareFirst;
            }
            return compareFirst;
        });
        
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            int[] currentInterval = intervals[i];
            if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < currentInterval[0]){
                ans.add(currentInterval);
            }
            else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], currentInterval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);

    }
}
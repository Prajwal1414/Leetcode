class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int compareFirst = Integer.compare(a[0], b[0]);
            if (compareFirst == 0) {
                compareFirst = Integer.compare(a[1], b[1]);
                return compareFirst;
            }
            return compareFirst;

        });

        List<List<Integer>> ans = new ArrayList<>();

        int n = intervals.length;
        int i = 0;
        while(i < n) {
            ArrayList<Integer> cur = new ArrayList<>();
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;

            while(j < n && intervals[j][0] <= end){
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            cur.add(start);
            cur.add(end);
            ans.add(cur);
           
           i = j;

        }

        return ans.stream()
                    .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                    .toArray(int[][]::new);
    }
}
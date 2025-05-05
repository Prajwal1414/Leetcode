class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int length = grid.length;
        
        long n = length * length;

        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n  + 1) * ((2 *n) + 1)) / 6;
        long S = 0, S2 = 0;
        for(int i = 0; i < length; i++){
            for(long num : grid[i]){
                S += num;
                S2 += num * num;
            }
        }
        
        long val1 = S - SN;
        long val2 = S2 - S2N;
        val2 = val2 / val1;

        long x = (val1 + val2) / 2;
        long y = (val2) - x;

        return new int[] {(int)x, (int)y};
    }
}
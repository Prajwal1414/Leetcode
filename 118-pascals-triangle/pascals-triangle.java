class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(1));
        for(int i = 1 ; i < numRows; i++){
            ans.add(getRow(i));
        }

        return ans;
    }

    public static List<Integer> getRow(int row){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        long res = 1;
        for(int i = 1; i <= row; i++){
            res = res * (row - i + 1);
            res = res / i;
            ans.add((int) res);
        }
        return ans;
    }
}
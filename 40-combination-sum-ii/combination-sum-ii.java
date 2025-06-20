class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
       Set<List<Integer>> ans = new HashSet<>();
       findComb(0, target, candidates, ans, new ArrayList<>());
        List<List<Integer>> result = new ArrayList<>(ans)       ;
       return result;
    }

    public void findComb(int index, int target, int[] arr, Set<List<Integer>> ans, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(target < 0 || index == arr.length){
            return;
        }
        if(arr[index] <= target){
            ds.add(arr[index]);
            findComb(index + 1, target - arr[index], arr, ans, ds);
            ds.remove(ds.size() - 1);
        }

        while(index + 1 < arr.length && arr[index] == arr[index + 1]){
            index++;
        }

        findComb(index + 1, target, arr, ans , ds);
    }
}
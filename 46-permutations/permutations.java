class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        recPerm(nums, ds, ans, visited);
        return ans;

    }

    public void recPerm(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] visited){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0 ; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                ds.add(nums[i]);
                recPerm(nums, ds, ans, visited);
                ds.remove(ds.size() - 1);
                visited[i] = false;
            }
        }
    }
}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {

                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long)nums[left] + (long) nums[right];
                    long comp = (long)target - (long)(nums[i] + nums[j]);

                    if (sum == comp) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (sum < comp) {
                        left++;
                    } else
                        right--;

                }

            }
        }
        
        return ans;
    }
}
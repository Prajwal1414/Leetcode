class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low) / 2;

            ans = Math.min(ans, nums[mid]);
            if(nums[mid] >= nums[low]){
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }
            else{
                ans = Math.min(ans, nums[mid + 1]);
                high = mid - 1;
            }
        }

        return ans;
    }
}
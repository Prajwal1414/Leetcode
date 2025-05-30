class Solution {
    public int findPeakElement(int[] nums) {
        int low = 1;
        int n = nums.length;
        int high = n - 2;

        int max = Integer.MIN_VALUE;
        int index = -1;

        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n -1;
        while(low <= high){
            int mid = low +(high - low) / 2;

            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                max = nums[mid];
                index = mid;
                return mid;
            }

            else if (nums[low] <= nums[mid] && nums[mid] <= nums[mid + 1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return 0;

    }
}
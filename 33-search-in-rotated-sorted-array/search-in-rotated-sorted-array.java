class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r){
            int mid = l + (r - l) / 2;

            if(nums[mid] == target) return mid;

            //if left half is sorted
            if(nums[l] <= nums[mid]){
                //does the target exist in the left half
                if(nums[l] <= target && target <= nums[mid]){
                    r = mid - 1;
                }
                //target does not exist in the left half so look in the right half
                else{
                    l = mid + 1;
                }
            }
            //right half is sorted
            else{
                //does target exist in the right half
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid + 1;
                }
                //target is not in the right sorted half go to left half
                else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
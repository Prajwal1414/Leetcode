class Solution {
    public int search(int[] nums, int target) {
        
        return binarySearch(nums, target, 0, nums.length - 1);


    }

    public int binarySearch(int[] nums, int target, int start, int end){
        int low = start;
        int high = end; 
        int mid = (low + high) / 2;

        if(low > high) return -1;

        if(nums[mid] == target) return mid;

        if(nums[mid] < target){
           return binarySearch(nums, target, mid + 1, high);
        }
        else{
            return binarySearch(nums,target, 0, mid - 1);
        }

        
    }
}
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(mid <= high){
           
            switch(nums[mid]){
                case 0: swap(nums, low , mid);
                        low++;
                        mid++;
                        break;

                case 1: mid++;
                        break;

                case 2: swap(nums, mid, high);
                        high--;
                        break;
            }

            
        }
    }

    public static void swap(int[] arr, int i, int j){
        final int temp = arr[i];
        arr[i] = arr[j]; 
        arr[j] = temp;
    }
}